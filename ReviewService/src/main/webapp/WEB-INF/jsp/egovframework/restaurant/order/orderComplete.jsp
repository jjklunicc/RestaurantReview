<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>주문 내역 리스트</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/payment.css'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/main.css'/>"/>
     <script type="text/javaScript" language="javascript" defer="defer"></script>
</head>
<body  class="asp_check" style="margin-top: 0px;">
  <header class="header text-uppercase header-main-text" id="mainHeader">
    <div class="container header-main-text">
      <div>Restaurant Review</div>
    </div>
  </header>
  <main class="container">    
  	<div style="margin: 50px 0px;">
        <div class="sub-title">
          <span>주문완료</span>
        </div>
        <div class="panel panel-default order-complete-msg">
          <div class="panel-body txt-msg1">
            <p class="text-danger msg-title">주문 감사합니다</p>
            <p class="msg-body">주문 요청이 완료되었으며 고객님의 휴대전화 번호로 주문 확인 문자가 곧 발송 됩니다.</p>
            <p class="msg-body msg-warning">주문 정보를 가져오는데 실패 했습니다. 고객님의 휴대전화 번호로 주문 확인 문자가 발송되지 않을 경우 고객센터(1661-5270)로 문의
              바랍니다.</p>
          </div>
        </div>
        <div class="panel-group">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h4 class="panel-title">
                배달정보
              </h4>
            </div>
            <div class="panel-collapse">
              <div class="panel-body">
                <div class="form-horizontal">
                  <div class="form-group">
                    <div class="col-xs-3 col-sm-2 control-label">주문식당</div>
                    <div class="col-xs-9 col-sm-9 ng-binding" ng-bind="checkout.result.restaurant_name">[주문식당 이름]</div>
                  </div>
                  <div class="form-group">
                    <div class="col-xs-3 col-sm-2 control-label">결제수단</div>
                    <div class="col-xs-9 col-sm-9">
                      <span ng-show="checkout.order.payment != 'oneclick'" class="ng-binding">[결제방식 - ]</span>
                      <span class="ng-binding">[카드 혹은 현금]</span>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-xs-3 col-sm-2 control-label">주문자정보</div>
                    <div class="col-xs-9 col-sm-9 ng-binding" ng-bind="checkout.order.description">[주문자 정보 주소]</div>
                    <div class="col-xs-offset-3 col-xs-9 col-sm-offset-2 col-sm-10 ng-binding"
                      ng-bind="checkout.order.phone">[주문자 정보 전화번호]</div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="panel panel-default">
            <div class="panel-heading">
              <h4 class="panel-title">
                주문내역
              </h4>
            </div>
            <div class="panel-collapse">
              <div class="panel-body order-content">
                <ul class="list-group order-list">
                  <li class="list-group-item total-order-price clearfix">
                    <!-- ngRepeat: item in checkout.cart.items -->
                    <div class="order-item clearfix ng-scope" ng-repeat="item in checkout.cart.items">
                      <div class="order-name"><span ng-bind="cart.get_menu_name(item)|strip_html"
                          class="ng-binding">페이머스 글레이즈드 기프트팩（6개입）</span> x <span ng-bind="item.amount"
                          class="ng-binding">1</span>개</div>
                      <div class="order-price ng-binding" ng-bind="(item.price * item.amount)|krw">7,800원</div>
                    </div><!-- end ngRepeat: item in checkout.cart.items -->
                    <div class="order-item clearfix ng-scope" ng-repeat="item in checkout.cart.items">
                      <div class="order-name"><span ng-bind="cart.get_menu_name(item)|strip_html"
                          class="ng-binding">베이컨에그 잉글리쉬머핀</span> x <span ng-bind="item.amount"
                          class="ng-binding">1</span>개</div>
                      <div class="order-price ng-binding" ng-bind="(item.price * item.amount)|krw">3,000원</div>
                    </div><!-- end ngRepeat: item in checkout.cart.items -->
                    <div class="order-item clearfix ng-scope" ng-repeat="item in checkout.cart.items">
                      <div class="order-name"><span ng-bind="cart.get_menu_name(item)|strip_html"
                          class="ng-binding">페이머스 글레이즈드</span> x <span ng-bind="item.amount"
                          class="ng-binding">1</span>개</div>
                      <div class="order-price ng-binding" ng-bind="(item.price * item.amount)|krw">1,300원</div>
                    </div><!-- end ngRepeat: item in checkout.cart.items -->
                    <div class="order-item clearfix ng-hide" ng-show="additional_price > 0">
                      <div class="order-name">추가 금액</div>
                      <div class="order-price ng-binding" ng-bind="additional_price|krw">0원</div>
                    </div>
                    <div class="order-item clearfix" ng-show="checkout.cart.restaurant.delivery_fee > 0">
                      <div class="order-name">배달료</div>
                      <div class="order-price ng-binding" ng-bind="checkout.cart.restaurant.delivery_fee|krw">2,000원
                      </div>
                    </div>
                    <!-- ngRepeat: item in checkout.result.discountDetail -->
                    <div class="order-item clearfix total-order">
                      <div class="order-name text-danger">총 결제 금액</div>
                      <div class="order-price text-danger ng-binding" ng-bind="total_payment_price()|krw">14,100원</div>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
  </main>
  <footer class="footer text-center">
    <div class="container">
      <h4>융합 서비스 프로젝트</h4>
      <div class="text-center">
        Copyright &copy; BCU 2021
      </div>
    </div>
  </footer>
</body>
</html>