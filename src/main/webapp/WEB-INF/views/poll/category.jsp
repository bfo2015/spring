<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../include/header.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
   <!-- Content Header (Page header) -->
  

   <!-- Main content -->
   <section class="content">


      <!-- =========================================================== -->


      <!-- =========================================================== -->

      <!-- Small boxes (Stat box) -->
      <div class="row">
         <div class="box">
            <div class="box-header">
               <h3 class="box-title">category</h3>
            </div>
            <div class="box-body">


               <c:forEach items="${categoryList}" var="categoryVO">
                  <div class="col-lg-3 col-xs-6">
                     <!-- small box -->


                     <c:choose>
                        <c:when test="${categoryVO.categoryName eq '선호도조사'}">
                           <a href="/poll/pollsetting?pno=${categoryVO.categoryNo}"
                              class="small-box bg-fuchsia-active">
                              <div class="inner">
                                 <h3>${categoryVO.categoryName}</h3>
                                 <p>click</p>
                              </div>
                              <div class="icon">
                                 <i class="fa fa-gratipay"></i>
                              </div>
                           </a>
                        </c:when>

                        <c:when test="${categoryVO.categoryName eq '세미나'}">
                           <a href="/poll/pollsetting?pno=${categoryVO.categoryNo}"
                              class="small-box bg-maroon-gradient">
                              <div class="inner">
                                 <h3>${categoryVO.categoryName}</h3>
                                 <p>click</p>
                              </div>
                              <div class="icon">
                                 <i class="fa fa-black-tie"></i>
                              </div>
                           </a>
                        </c:when>

                        <c:when test="${categoryVO.categoryName eq '강의'}">
                           <a href="/poll/pollsetting?pno=${categoryVO.categoryNo}" class="small-box bg-teal">
                              <div class="inner">
                                 <h3>${categoryVO.categoryName}</h3>
                                 <p>click</p>
                              </div>
                              <div class="icon">
                                 <i class="fa fa-microphone"></i>
                              </div>
                           </a>
                        </c:when>

                        <c:when test="${categoryVO.categoryName eq '마케팅'}">
                           <a href="/poll/pollsetting?pno=${categoryVO.categoryNo}"
                              class="small-box bg-purple-gradient">
                              <div class="inner">
                                 <h3>${categoryVO.categoryName}</h3>
                                 <p>click</p>
                              </div>
                              <div class="icon">
                                 <i class="fa fa-bar-chart"></i>
                              </div>
                           </a>
                        </c:when>

                        <c:when test="${categoryVO.categoryName eq '방송'}">
                           <a href="/poll/pollsetting?pno=${categoryVO.categoryNo}" class="small-box bg-aqua">
                              <div class="inner">
                                 <h3>${categoryVO.categoryName}</h3>
                                 <p>click</p>
                              </div>
                              <div class="icon">
                                 <i class="fa fa-video-camera"></i>
                              </div>
                           </a>
                        </c:when>

                        <c:when test="${categoryVO.categoryName eq '스포츠'}">
                           <a href="/poll/pollsetting?pno=${categoryVO.categoryNo}" class="small-box bg-green">
                              <div class="inner">
                                 <h3>${categoryVO.categoryName}</h3>
                                 <p>click</p>
                              </div>
                              <div class="icon">
                                 <i class="fa fa-futbol-o"></i>
                              </div>
                           </a>
                        </c:when>

                        <c:when test="${categoryVO.categoryName eq '서명'}">
                           <a href="/poll/pollsetting?pno=${categoryVO.categoryNo}" class="small-box bg-yellow">
                              <div class="inner">
                                 <h3>${categoryVO.categoryName}</h3>
                                 <p>click</p>
                              </div>
                              <div class="icon">
                                 <i class="fa fa-strikethrough"></i>
                              </div>
                           </a>
                        </c:when>

                        <c:when test="${categoryVO.categoryName eq '직접설정'}">
                           <a href="/poll/pollsetting?pno=${categoryVO.categoryNo}" class="small-box bg-red">
                              <div class="inner">
                                 <h3>${categoryVO.categoryName}</h3>
                                 <p>click</p>
                              </div>
                              <div class="icon">
                                 <i class="fa fa-star"></i>
                              </div>
                           </a>
                        </c:when>
                     </c:choose>

                  </div>
                  <!-- ./col -->
               </c:forEach>

            </div>
            <!-- /.row -->

         </div>
         <!-- /.box-body -->

      </div>
      <!-- /.row -->

      <!-- =========================================================== -->

      <!-- =========================================================== -->


      <!-- =========================================================== -->

      <!-- Direct Chat -->
</section>
</div>

<script>
console.log("=======^^");
console.log("${login}");
console.log("${memberVO}");
</script>

<%@include file="../include/footer.jsp"%>

<!-- Slimscroll -->
<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>


</body>
</html>