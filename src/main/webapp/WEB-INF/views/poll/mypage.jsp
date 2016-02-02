<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../include/header.jsp" %>
    
 <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->


        <!-- Main content -->
        <section class="content">
            <div class="row">

                <div class="col-md-8">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">내투표들</h3>
                            <div class="box-tools pull-right">
                                <div class="has-feedback">
                                    <input type="text" class="form-control input-sm" placeholder="Search Mail">
                                    <span class="glyphicon glyphicon-search form-control-feedback"></span>
                                </div>
                            </div><!-- /.box-tools -->
                        </div><!-- /.box-header -->
                        <div class="box-body no-padding">
                            <div class="mailbox-controls">
                                <!-- Check all button -->
                                <button class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i></button>
                                <div class="btn-group">
                                    <button class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                                    <button class="btn btn-default btn-sm"><i class="fa fa-reply"></i></button>
                                    <button class="btn btn-default btn-sm"><i class="fa fa-share"></i></button>
                                </div><!-- /.btn-group -->
                                <button class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button>
                                <div class="pull-right">
                                    1-50/200
                                    <div class="btn-group">
                                        <button class="btn btn-default btn-sm"><i class="fa fa-chevron-left"></i></button>
                                        <button class="btn btn-default btn-sm"><i class="fa fa-chevron-right"></i></button>
                                    </div><!-- /.btn-group -->
                                </div><!-- /.pull-right -->
                            </div>
                            <div class="table-responsive mailbox-messages">
                                <table class="table table-hover table-striped">

                                    <thead>
                                    <tr>
                                        <th> </th>
                                        <th>카테고리</th>
                                        <th>투표 제목</th>
                                        <th>참여자수</th>
                                        <th>첨부파일</th>
                                        <th>등록일자</th>
                                        <th>진행상황</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-subject"><b>방송</b></td>
                                        <td class="mailbox-name"><a href="read-mail.html">오늘 가장 재밌던 프로그램은?</a></td>
                                        <td>12</td>
                                        <td class="mailbox-attachment"></td>
                                        <td>2015-12-20</td>
                                        <td><span class="label label-danger">투표중</span></td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-subject"><b>방송</b></td>
                                        <td class="mailbox-name"><a href="read-mail.html">오늘 가장 재밌던 프로그램은?</a></td>
                                        <td>12</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td>2015-12-20</td>
                                        <td><span class="label label-success">마감</span></td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-subject"><b>방송</b></td>
                                        <td class="mailbox-name"><a href="read-mail.html">오늘 가장 재밌던 프로그램은?</a></td>
                                        <td>12</td>
                                        <td class="mailbox-attachment"></td>
                                        <td>2015-12-20</td>
                                        <td><span class="label label-success">마감</span></td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-subject"><b>방송</b></td>
                                        <td class="mailbox-name"><a href="read-mail.html">오늘 가장 재밌던 프로그램은?</a></td>
                                        <td>12</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td>2015-12-20</td>
                                        <td><span class="label label-success">마감</span></td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-subject"><b>방송</b></td>
                                        <td class="mailbox-name"><a href="read-mail.html">오늘 가장 재밌던 프로그램은?</a></td>
                                        <td>12</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td>2015-12-20</td>
                                        <td><span class="label label-success">마감</span></td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-subject"><b>방송</b></td>
                                        <td class="mailbox-name"><a href="read-mail.html">오늘 가장 재밌던 프로그램은?</a></td>
                                        <td>12</td>
                                        <td class="mailbox-attachment"></td>
                                        <td>2015-12-20</td>
                                        <td><span class="label label-success">마감</span></td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-subject"><b>방송</b></td>
                                        <td class="mailbox-name"><a href="read-mail.html">오늘 가장 재밌던 프로그램은?</a></td>
                                        <td>12</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td>2015-12-20</td>
                                        <td><span class="label label-success">마감</span></td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-subject"><b>방송</b></td>
                                        <td class="mailbox-name"><a href="read-mail.html">오늘 가장 재밌던 프로그램은?</a></td>
                                        <td>12</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td>2015-12-20</td>
                                        <td><span class="label label-success">마감</span></td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-subject"><b>방송</b></td>
                                        <td class="mailbox-name"><a href="read-mail.html">오늘 가장 재밌던 프로그램은?</a></td>
                                        <td>12</td>
                                        <td class="mailbox-attachment"></td>
                                        <td>2015-12-20</td>
                                        <td><span class="label label-success">마감</span></td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-subject"><b>방송</b></td>
                                        <td class="mailbox-name"><a href="read-mail.html">오늘 가장 재밌던 프로그램은?</a></td>
                                        <td>12</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td>2015-12-20</td>
                                        <td><span class="label label-success">마감</span></td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-subject"><b>방송</b></td>
                                        <td class="mailbox-name"><a href="read-mail.html">오늘 가장 재밌던 프로그램은?</a></td>
                                        <td>12</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td>2015-12-20</td>
                                        <td><span class="label label-success">마감</span></td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-subject"><b>방송</b></td>
                                        <td class="mailbox-name"><a href="read-mail.html">오늘 가장 재밌던 프로그램은?</a></td>
                                        <td>12</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td>2015-12-20</td>
                                        <td><span class="label label-success">마감</span></td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-subject"><b>방송</b></td>
                                        <td class="mailbox-name"><a href="read-mail.html">오늘 가장 재밌던 프로그램은?</a></td>
                                        <td>12</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td>2015-12-20</td>
                                        <td><span class="label label-success">마감</span></td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-subject"><b>방송</b></td>
                                        <td class="mailbox-name"><a href="read-mail.html">오늘 가장 재밌던 프로그램은?</a></td>
                                        <td>12</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td>2015-12-20</td>
                                        <td><span class="label label-success">마감</span></td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-subject"><b>방송</b></td>
                                        <td class="mailbox-name"><a href="read-mail.html">오늘 가장 재밌던 프로그램은?</a></td>
                                        <td>12</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td>2015-12-20</td>
                                        <td><span class="label label-success">마감</span></td>
                                    </tr>
                                    </tbody>
                                </table><!-- /.table -->
                            </div><!-- /.mail-box-messages -->
                        </div><!-- /.box-body -->
                        <div class="box-footer no-padding">
                            <div class="mailbox-controls">
                                <!-- Check all button -->
                                <button class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i></button>
                                <div class="btn-group">
                                    <button class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                                    <button class="btn btn-default btn-sm"><i class="fa fa-reply"></i></button>
                                    <button class="btn btn-default btn-sm"><i class="fa fa-share"></i></button>
                                </div><!-- /.btn-group -->
                                <button class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button>
                                <div class="pull-right">
                                    1-50/200
                                    <div class="btn-group">
                                        <button class="btn btn-default btn-sm"><i class="fa fa-chevron-left"></i></button>
                                        <button class="btn btn-default btn-sm"><i class="fa fa-chevron-right"></i></button>
                                    </div><!-- /.btn-group -->
                                </div><!-- /.pull-right -->
                            </div>
                        </div>
                    </div><!-- /. box -->
                </div><!-- /.col -->


                <div class="col-md-3">
                    <!-- Info Boxes Style 2 -->

                    <div >
                        <button class="btn btn-block btn-warning btn-lg">투표만들기</button>
                    </div><!-- /.info-box -->

                </div>

            </div><!-- /.row -->




        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->

<!-- Page Script -->
<script>
    $(function () {
        //Enable iCheck plugin for checkboxes
        //iCheck for checkbox and radio inputs
        $('.mailbox-messages input[type="checkbox"]').iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat-blue'
        });

        //Enable check and uncheck all functionality
        $(".checkbox-toggle").click(function () {
            var clicks = $(this).data('clicks');
            if (clicks) {
                //Uncheck all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("uncheck");
                $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
            } else {
                //Check all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("check");
                $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
            }
            $(this).data("clicks", !clicks);
        });

        //Handle starring for glyphicon and font awesome
        $(".mailbox-star").click(function (e) {
            e.preventDefault();
            //detect type
            var $this = $(this).find("a > i");
            var glyph = $this.hasClass("glyphicon");
            var fa = $this.hasClass("fa");

            //Switch states
            if (glyph) {
                $this.toggleClass("glyphicon-star");
                $this.toggleClass("glyphicon-star-empty");
            }

            if (fa) {
                $this.toggleClass("fa-star");
                $this.toggleClass("fa-star-o");
            }
        });
    });

<%@include file="../include/footer.jsp" %>

  </body>
</html>