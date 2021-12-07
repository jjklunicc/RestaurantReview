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
  	<div class="col-sm-8">
    <div class="sub-title">
      <span>결제하기</span>
    </div>
    <div class="panel-group" data-allow-multiple="true" bs-collapse="">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h4 class="panel-title">
            <a bs-collapse-toggle="" class="clearfix" ng-click="delivery_collapse = !delivery_collapse"
              data-toggle="collapse">
              <span class="menu-name pull-left">배달정보</span>
              <i class="pull-right icon-arr-up" ng-class="delivery_icon_down_up"></i>
            </a>
          </h4>
        </div>
        <div class="panel-collapse collapse am-collapse in" bs-collapse-target="">
          <div class="panel-body">
            <div class="form-horizontal">
              <div class="form-group">
                <label for="address" class="col-sm-2 control-label">주소</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control address1" placeholder="배달 주소" name="address"
                    ng-value="session_storage.checkout_input.address" ng-readonly="true" ng-disabled="true"
                    value="경기도 부천시 계수동 791 부천대학교 제2캠퍼스" readonly="readonly" disabled="disabled">
                </div>
              </div>
              <div class="form-group
                  ">
                <div class="col-sm-offset-2 col-sm-10">
                  <input type="text" class="form-control ng-pristine ng-untouched ng-invalid ng-invalid-required"
                    placeholder="(필수)상세주소 입력" name="address_detail"
                    ng-model="session_storage.checkout_input.address_detail" ng-blur="check_address_detail($event)"
                    ng-required="true" required="required">
                  <span class="help-block mar0 ng-hide"
                    ng-show="(form_checkout.$submitted || form_checkout.address_detail.$touched)"><span
                      class="text-danger" ng-show="form_checkout.address_detail.$error.required">상세한 주소를
                      입력해주세요.</span></span>
                </div>
              </div>
              <div class="form-group
                  ">
                <label for="phone" class="col-sm-2 control-label">휴대전화번호</label>

                <div class="ol-sm-offset-2 col-sm-10">
                  <div class="">
                    <input type="tel"
                      class="form-control input-type1 ng-pristine ng-untouched ng-invalid ng-invalid-required ng-valid-pattern"
                      placeholder="(필수)휴대전화 번호 입력" name="phone" ng-pattern="/^[0-9]+$/"
                      ng-model="session_storage.checkout_input.phone" ng-required="true" ng-valid=""
                      ng-change="update_phone_number()" ng-class="sms_verified ? 'success' : ''" required="required">
                  </div>

                  <span class="help-block mar0 ng-hide"
                    ng-show="form_checkout.$submitted || form_checkout.phone.$touched">
                    <span class="text-danger" ng-show="form_checkout.phone.$error.required">전화번호를 입력해주세요. (050 등 안심번호
                      사용 불가)</span>
                    <span class="text-danger ng-hide" ng-show="form_checkout.phone.$error.pattern">휴대전화번호는 숫자만
                      입력해주세요.</span>
                  </span>
                </div>
              </div>

              <div class="col-sm-offset-2 col-sm-10 check-set"
                ng-show="session_storage.service_info.safen_number_checkbox">
                <div>
                  <div class="safe-num">
                    <input type="checkbox" id="c6" ng-model="safen_number_checked" ng-disabled="disable_safen_number"
                      class="ng-pristine ng-untouched ng-valid">
                    <label for="c6"><span></span><small>안심번호 사용</small></label>
                    <i class="btn-tooltip"></i>
                    <div class="up-arrow">
                      안심번호는 고객님의 개인정보 보호를 위해<br>연락처 정보가 유출되지 않도록<br><em>1회성 임시번호를 발급</em>하는 서비스 입니다.<br>발급된 안심번호는 일정시간
                      이후<br>자동으로 해지됩니다.
                    </div>
                    <div class="disable-safe-num ng-hide" ng-show="disable_safen_number">
                      안심번호를 지원하지 않는 음식점입니다.
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="panel panel-default" bs-collapse="">
        <div class="panel-heading">
          <h4 class="panel-title">
            <a bs-collapse-toggle="" class="clearfix" ng-click="select_order_request()" data-toggle="collapse">
              <span class="menu-name pull-left">주문시 요청사항</span>
              <i class="pull-right icon-arr-up" ng-class="request_icon_down_up"></i>
            </a>
          </h4>
        </div>
        <div class="panel-collapse collapse am-collapse in" bs-collapse-target="">
          <div class="panel-body">
            <textarea class="form-control ng-pristine ng-untouched ng-valid ng-valid-maxlength" rows="3"
              ng-blur="check_order_request($event)" name="comment" ng-model="session_storage.checkout_input.comment"
              maxlength="100"
              placeholder="코로나19 예방을 위해 비대면 배달 권장드립니다. 결제 선택 후, &quot;문 앞 배달&quot;을 요청사항에 남겨주세요."></textarea>
            <div class="txt-limit">
              <div class="txt-length ng-binding">0 / 100</div>
              <span class="help-block ng-hide" ng-show="(session_storage.checkout_input.comment.length) >= 100">
                <span class="text-danger">최대 100자까지 입력 가능합니다.</span>
              </span>
            </div>
          </div>
        </div>
      </div>

      <div class="panel panel-default clearfix" ng-show="is_yogiyo">
        <div class="panel-heading">
          <h4 class="panel-title">
            <a class="clearfix">
              결제수단 선택 <span ng-show="!is_show_creditcard &amp;&amp; !is_show_cash" class="ng-hide">(현장 결제는 지원하지
                않습니다.)</span>
            </a>
          </h4>
        </div>
        <div class="panel-collapse collapse am-collapse in">
          <div class="panel-body payment-wrap">
            <div class="ygy-payment clearfix" ng-show="check_enable_online_payment()">
              <div>
                <strong>결제</strong> <span class="stxt">웹에서 미리 결제</span>
                <span ng-show="is_yogiyo &amp;&amp; is_discount()" class="ng-hide">
                  <span class="coupon ng-binding ng-hide" ng-show="delivery_discount_value() != 0">0원</span>
                  <span class="coupon1 ng-binding ng-hide" ng-show="additional_discount_value() != 0">-0%</span>
                </span>
                <span class="txt-ie" ng-show="!is_mobile_device &amp;&amp; !is_ie"><br><em>* 신용카드와 휴대전화 결제는 Internet
                    Explorer에서 가능합니다.</em></span>
              </div>
              <div class="btn-group">
                <label class="btn btn-default disabled" ng-show="is_yogiyo"
                  ng-class="!is_mobile_device &amp;&amp; !is_ie ? 'disabled' : ''">
                  <i class="icon-check icon-card"></i> <input type="radio" name="payment"
                    class="btn btn-default ng-pristine ng-untouched ng-valid ng-valid-required"
                    ng-model="session_storage.checkout_input.payment" value="onlycard" ng-required="true" bs-radio=""
                    ng-click="select_payment($event)" required="required">신용카드
                </label>
                <label class="btn btn-default disabled" ng-show="is_yogiyo"
                  ng-class="!is_mobile_device &amp;&amp; !is_ie ? 'disabled' : ''">
                  <i class="icon-check icon-phone"></i> <input type="radio" name="payment"
                    class="btn btn-default ng-pristine ng-untouched ng-valid ng-valid-required"
                    ng-model="session_storage.checkout_input.payment" value="onlyhpp" ng-required="true" bs-radio=""
                    ng-click="select_payment($event)" required="required">휴대전화
                </label>
                <label class="btn btn-default" ng-show="enabled_npay()">
                  <i class="icon-check icon-npay"></i> <input type="radio" name="payment"
                    class="btn btn-default ng-pristine ng-untouched ng-valid ng-valid-required"
                    ng-model="session_storage.checkout_input.payment" value="naverpay" ng-required="true" bs-radio=""
                    ng-click="select_payment($event)" required="required">네이버페이
                </label>
                <label class="btn btn-default" ng-show="enabled_smilepay()">
                  <i class="icon-check icon-smilepay"></i> <input type="radio" name="payment"
                    class="btn btn-default ng-pristine ng-untouched ng-valid ng-valid-required"
                    ng-model="session_storage.checkout_input.payment" value="smilepay" ng-required="true" bs-radio=""
                    ng-click="select_payment($event)" required="required">스마일페이
                </label>
                <label class="btn btn-default" ng-show="enabled_chaipay()">
                  <i class="icon-check icon-chaipay"></i> <input type="radio" name="payment"
                    class="btn btn-default ng-pristine ng-untouched ng-valid ng-valid-required"
                    ng-model="session_storage.checkout_input.payment" value="chaipay" ng-required="true" bs-radio=""
                    ng-click="select_payment($event)" required="required">차이
                </label>
              </div>
            </div>

            <div ng-show="is_show_creditcard || is_show_cash"><strong>현장결제</strong> <span class="stxt">음식받고 직접
                결제</span>
              <p ng-show="check_enable_online_payment() &amp;&amp; is_discount()" class="ng-hide">*결제시에만 할인 혜택을 받을
                수 있습니다.</p>
            </div>
            <div class="btn-group clearfix" ng-show="is_show_creditcard || is_show_cash">
              <label class="btn btn-default active" ng-show="is_show_creditcard"
                ng-class="is_show_cash ? '':'btn-full'">
                <i class="icon-check icon-card"></i> <input type="radio" name="payment"
                  class="btn btn-default ng-pristine ng-untouched ng-valid ng-valid-required"
                  ng-model="session_storage.checkout_input.payment" value="creditcard" ng-required="true" bs-radio=""
                  ng-click="select_payment($event)" required="required">신용카드
              </label>
              <label class="btn btn-default" ng-show="is_show_cash" ng-class="is_show_creditcard ? '':'btn-full'">
                <i class="icon-check icon-money"></i> <input type="radio" name="payment"
                  class="btn btn-default ng-pristine ng-untouched ng-valid ng-valid-required"
                  ng-model="session_storage.checkout_input.payment" value="cash" ng-required="true" bs-radio=""
                  ng-click="select_payment($event)" required="required">현금
              </label>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="panel-group" ng-show="is_yogiyo &amp;&amp; check_enable_online_payment()
    &amp;&amp; (is_discount() == false || (is_discount() &amp;&amp; additional_discount_can_use_coupon))">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h4 class="panel-title">
            <a class="clearfix">
              할인방법 선택
            </a>
          </h4>
        </div>

        <div class="panel-body">
          <div class="form-group coupon-wrap ">
            <label for="coupon" class="col-xs-2 control-label">쿠폰</label>
            <div class="col-xs-10 onspot_payment">
              <div class="input-group">
                <input type="text" class="form-control input-type1 ng-pristine ng-untouched ng-valid"
                  placeholder="결제시 사용 가능합니다." name="coupon"
                  ng-readonly="session_storage.checkout_input.payment == 'creditcard' || session_storage.checkout_input.payment == 'cash' || coupon_verified == true"
                  ng-disabled="(session_storage.checkout_input.payment == 'creditcard' || session_storage.checkout_input.payment == 'cash' || coupon_verified == true)"
                  ng-model="input_coupon_code" ng-keypress="apply_coupon($event)" readonly="readonly"
                  disabled="disabled">
                <span class="input-group-btn">
                  <a class="btn btn-default btn-ygy2 ng-binding" ng-bind="btn_coupon" ng-click="apply_coupon()">적용</a>
                </span>
              </div>
            </div>
            <div class="col-xs-offset-2 col-xs-10 ng-hide" ng-show="check_invalid_coupon()">
              <p class="msg-err-code ng-binding" ng-bind="invalid_coupon_message"></p>
            </div>
          </div>
        </div>

      </div>
    </div>
  </div>
  <div class="col-sm-4 order-wrap-pc">
    <div class="order-list">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">주문내역</h3>
        </div>
        <div class="panel-body checkout-order-list">
          <div class="list-group-item restaurant_name ng-binding" ng-bind="cart.get().restaurant_name">인생아구찜</div>
          <ul class="list-group order-list">
            <!-- ngRepeat: item in cart.get().items -->
            <li class="list-group-item ng-scope" ng-repeat="item in cart.get().items" ng-show="item.amount > 0">
              <div class="order-item clearfix">
                <div class="order-name">
                  <span ng-bind-html="cart.get_menu_name(item)|strip_html" class="ng-binding">종합영양제 해물아구찜 （ 인기 ）: 小,
                    순한맛（약간은 매콤합니다.）, 기본（슴슴하고 깔끔）</span>
                  x
                  <span ng-bind="item.amount" class="ng-binding">1</span>개
                </div>
                <div class="order-price ng-binding" ng-bind="(item.price * item.amount)|krw">30,000원</div>
              </div>
            </li><!-- end ngRepeat: item in cart.get().items -->
          </ul>
          <div class="list-group1">
            <span class="list-group-item clearfix ng-hide" ng-show="additional_price > 0">
              <div class="order-name">추가 금액</div>
              <div class="order-price"><span ng-bind="additional_price|krw" class="ng-binding">(21,000)원</span></div>
            </span>
            <span class="list-group-item clearfix" ng-show="delivery_fee > 0">
              <div class="order-name">배달료</div>
              <div class="order-price"><span ng-bind="delivery_fee|krw" class="ng-binding">1,500원</span></div>
            </span>
            <span class="list-group-item clearfix ng-hide"
              ng-show="is_yogiyo &amp;&amp; get_delivery_discount_total() < 0 &amp;&amp; is_online_payment()">
              <div class="order-name ng-binding">즉시할인 </div>
              <div class="order-price"><span ng-bind="get_delivery_discount_total_krw()" class="ng-binding">0원</span>
              </div>
            </span>
            <span class="list-group-item clearfix ng-hide"
              ng-show="is_yogiyo &amp;&amp; get_additional_discount_total() < 0 &amp;&amp; is_online_payment()">
              <div class="order-name">추가할인</div>
              <div class="order-price"><span ng-bind="get_additional_discount_total_krw()" class="ng-binding">0원</span>
              </div>
            </span>
            <span class="list-group-item clearfix ng-hide" ng-show="coupon_verified">
              <div class="order-name">쿠폰할인</div>
              <div class="order-price"><span ng-bind="coupon_discount" class="ng-binding"></span></div>
            </span>
            <span class="list-group-item total-order-price clearfix">
              <div class="order-name">총 결제 금액</div>
              <div class="order-price">
                <span ng-bind="total_price|krw" class="ng-binding">31,500원</span>
              </div>
            </span>
          </div>
        </div>
      </div>

      <div class="agree-set">
        <small>
          <span ng-hide="check_login()"><a href="#/policy/" target="_blank">이용약관</a>,</span>
          <span ng-hide="check_login()"><a ng-href="#/collect_default/" target="_blank" href="#/collect_default/">개인정보
              수집 및 이용</a>,</span>
          <span><a ng-href="#/partner/427121/" target="_blank" href="#/partner/427121/">개인정보 제3자 제공</a>
            <span ng-hide="check_login()">,</span>
            <span ng-hide="check_login()"><a ng-href="#/efinance_agreement/" target="_blank"
                href="#/efinance_agreement/">전자금융거래 이용약관</a>,</span>
            <span ng-hide="check_login()"><a href="/p/faq/#4-4" target="_blank">만 14세 이상 이용자</a></span> 내용 확인하였으며 결제에
            동의합니다.
          </span></small>
      </div>

      <div ng-show="is_11st &amp;&amp; check_enable_online_payment()" id="text_11st" class="ng-hide"></div>
      <!-- 11st 결제 -->
      <div class="panel panel-default clearfix payment-11st ng-hide" ng-show="is_11st">
        <div class="panel-heading">
          <h4 class="panel-title">
            <a class="clearfix">
              결제수단 선택
            </a>
          </h4>
        </div>
        <div class="panel-collapse collapse am-collapse in">
          <div class="panel-body payment-wrap">
            <div class="ygy-payment">
              <div class="txt-syrup-pay" ng-show="check_enable_online_payment()"><span>SK pay</span>주문 결제 시<br>보유하신
                할인혜택이 자동 적용됩니다.</div>
              <div class="btn-group">
                <label class="btn btn-oneclick disabled" ng-show="check_enable_online_payment()"
                  ng-class="!is_mobile_device &amp;&amp; !is_ie ? 'disabled' : ''">
                  <i class="icon-syrup"></i> <input type="radio" name="payment"
                    class="btn btn-default ng-pristine ng-untouched ng-valid ng-valid-required"
                    ng-model="session_storage.checkout_input.payment" value="oneclick" ng-required="true" bs-radio=""
                    ng-click="select_payment($event)" required="required">결제
                </label>
                <label class="btn btn-default-11st active" ng-show="is_show_creditcard">
                  <input type="radio" name="payment" ng-model="session_storage.checkout_input.payment"
                    value="creditcard" ng-required="true" bs-radio="" ng-click="select_payment($event)"
                    class="ng-pristine ng-untouched ng-valid ng-valid-required" required="required">배달원에게 신용카드 결제
                </label>
                <label class="btn btn-default-11st" ng-show="is_show_cash">
                  <input type="radio" name="payment" ng-model="session_storage.checkout_input.payment" value="cash"
                    ng-required="true" bs-radio="" ng-click="select_payment($event)"
                    class="ng-pristine ng-untouched ng-valid ng-valid-required" required="required">배달원에게 현금으로 결제
                </label>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- 11st 결제 -->
      <form method="post" action='orderComplete.do'>
      	<button class="btn btn-lg btn-block btn-ygy1 ng-binding" ng-click="prepare_checkout()"
       	 ng-bind="payment_button_text">결제하기</button>
      </form>
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