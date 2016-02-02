<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div class="content-wrapper">

  <section class="content">
	<div class="row">
	  <div class="col-md-12">
	    <div class="box box-primary">


          <div class="box-header with-border">
            <h3 class="box-title">상세내용 </h3>
            <a href="/poll/pollmodify?pno=${pollVO.pno}"><button type="submit" class="btn btn-info pull-right">수정하기</button></a>
            <form action="/poll/remove" class="pull-right" method="post">
            	<input type="hidden" value="${pollVO.pno}" name="pno">
            	<button type="submit" class="btn btn-default pull-right">삭제하기</button>
            </form>
          </div><!-- /.box-header -->

			<div class="box-header">

				<div class="form-group">
					<label >분 류</label>
					<input type="text" class="form-control" id="Category" readonly value="${pollVO.categoryCode}">
				</div>	
					
				<div class="form-group">					
					<label>url</label>
					<input type="text" class="form-control" id="Url" readonly value="${pollVO.pollAddr}">
				</div>

				<div class="form-group">
					<label >주 제</label>
					<input type="text" class="form-control" id="Topic" readonly	value="${pollVO.topic}">
				</div>

				<div class="form-group">
					<label >소 개</label>
					<input type="text" class="form-control" id="Intro" readonly	value="${pollVO.intro}"></input>
				</div>

				<div class="form-group">
					<label >기 간</label>
					<fmt:formatDate value="${pollVO.startDate}"
						pattern="yyyy-MM-dd HH:MM" var="startDate" />
					<fmt:formatDate value="${pollVO.endDate}"
						pattern="yyyy-MM-dd HH:MM" var="endDate" />
					<input type="text" class="form-control" id="period" readonly
						value="${startDate} ~ ${endDate}">
				</div>
			  </div>
			</div><!-- /.box-body -->
  
  
	  	<div class="box-footer">
	    	<label>항목</label>
			<div id="divItem"></div>
	    </div>
	    <br>
    
    <div class="box box-primary">
	    <div class="box-header with-border">
	      <div class="box-header box-primary">
	        <h3 class="box-title">결과분석 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h3>
	        <!-- 수정한곳 -->
	        
	      </div>
	    </div> 
     
	  <div class="box-body">    
	      <div class="col-md-6">
	        <!-- Bar chart -->
	        <div class="box box-primary">
	          <div class="box-header with-border">
	            <i class="fa fa-bar-chart-o"></i>
	            <h3 class="box-title">Bar Chart</h3>
	            <div class="box-tools pull-right">
	              <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
	              <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
	            </div>
	          </div>
	          <div class="box-body">
	            <div id="bar-chart" style="height: 300px;"></div>
	          </div><!-- /.box-body-->
	        </div><!-- /.box -->
	      </div>
	
	      <div class="col-md-6">
	        <!-- Donut chart -->
	        <div class="box box-primary">
	          <div class="box-header with-border">
	            <i class="fa fa-bar-chart-o"></i>
	            <h3 class="box-title">Donut Chart</h3>
	            <div class="box-tools pull-right">
	              <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
	              <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
	            </div>
	          </div>
	          <div class="box-body">
	            <div id="donut-chart" style="height: 300px;"></div>
	          </div><!-- /.box-body-->
	        </div><!-- /.box -->
	      </div><!-- /.col -->
	      </div>
	</div><!-- /.row -->
	</div>
	</div>
  </section><!-- /.content -->
</div>

<!-- Page script -->
<script>

var files = new Array();
var texts = new Array();

<c:forEach items="${itemVO.files}" var="file">
var fileName = "${file}" 
files.push(fileName);
</c:forEach>

<c:forEach items="${itemVO.texts}" var="text">
var itemText = "${text}" 
texts.push(itemText);
</c:forEach>

console.log(files);
console.log(texts);

$("small[name=1stFile]").text(files[0]);

if('${pollVO.answerCode}' != 'answer1'){
	$('#divItem').parent().remove();
}else{
	for(var i=1; i<files.length; i++){
	
		$('#divItem').append('<input type="text" name="itemText" class="form-control" placeholder="" readonly value='+texts[i]+'>'
		    +'<button type="submit" id="uploadbtn" class="btn btn-info btn-xs">첨부된 파일</button>'
		    +'<small id="itemFile">'+files[i]+'</small><br/><br/>');
	}
}






  $(function () {
    var bar_data = {
      data: [["January", 10], ["February", 8], ["March", 4], ["April", 13], ["May", 17], ["June", 9]],
      color: "#3c8dbc"
    };
    $.plot("#bar-chart", [bar_data], {
      grid: {
        borderWidth: 1,
        borderColor: "#f3f3f3",
        tickColor: "#f3f3f3"
      },
      series: {
        bars: {
          show: true,
          barWidth: 0.5,
          align: "center"
        }
      },
      xaxis: {
        mode: "categories",
        tickLength: 0
      }
    });

    var donutData = [
      {label: "Series2", data: 30, color: "#3c8dbc"},
      {label: "Series3", data: 20, color: "#0073b7"},
      {label: "Series4", data: 50, color: "#00c0ef"}
    ];
    $.plot("#donut-chart", donutData, {
      series: {
        pie: {
          show: true,
          radius: 1,
          innerRadius: 0.5,
          label: {
            show: true,
            radius: 2 / 3,
            formatter: labelFormatter,
            threshold: 0.1
          }

        }
      },
      legend: {
        show: false
      }
    });
    /*
     * END DONUT CHART
     */

  });

  /*
   * Custom Label formatter
   * ----------------------
   */
  function labelFormatter(label, series) {
    return '<div style="font-size:13px; text-align:center; padding:2px; color: #fff; font-weight: 600;">'
            + label
            + "<br>"
            + Math.round(series.percent) + "%</div>";
  }
</script>

<%@include file="../include/footer.jsp"%>

  </body>
</html>
