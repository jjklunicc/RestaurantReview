
function likeclick(element) {
  
  const checkboxes 
      = document.getElementsByName("click");
  
  // checkboxes.forEach((cb) => {
  //   if (cb == element) {
  //     cb.checked = true;
  //   }
  // })
  
  element.checked = true;
}
$(function(){
$('#toggle_btn').change(function(){
					const toggle_value = $('#toggle_btn').prop("checked")
					console.log(toggle_value);
					if(toggle_value==true){
						$(".button_area").css("display","inline-block");
						$(".button_area2").css("display","none");
					}
					else{
						$(".button_area").css("display","none");
						$(".button_area2").css("display","inline-block");
					}
				})
  $(".dropdown-menu li a").click(function(){
  var selText = $(this).text();
  $(this).parents('.btn-group').find('.dropdown-toggle').html(selText);
});
  var today = getTodayType();
  $(".date").text(today);
//   $("#like1").click(function(){
//     let index = $("#like1").index(this);
//     console.log(index);
//   })
  $("#modify_btn").click(function(){
    $(".review_content").attr("readonly", false);
  })
  $("#modify_btn2").click(function(){
    $(".owner_anwser").attr("readonly", false);
  })

  $(".cancle_btn").click(function(){
    let index = $(".cancle_btn").index(this);
    $(".cancle_btn:eq("+index+")").parent().parent().css("display","none");
  })

  $(".click_star").click(function(){
    let index = $(".click_star").index(this);
    console.log(index);
    if(index == 0){
      document.getElementById("starhidden").value = 1;
      $(".click_star:gt("+index+")").css("display", "none");
      $(".unclick_star:gt("+index+")").css("display","inline-block");
    }
    else if(index == 1){
      document.getElementById("starhidden").value = 2;
      $(".click_star:gt("+index+")").css("display", "none");
      $(".unclick_star:gt("+index+")").css("display","inline-block");
    }
    else if(index == 2){
      document.getElementById("starhidden").value = 3;
      $(".click_star:gt("+index+")").css("display", "none");
      $(".unclick_star:gt("+index+")").css("display","inline-block");
    }
    else if(index == 3){
      document.getElementById("starhidden").value = 4;
      $(".click_star:gt("+index+")").css("display", "none");
      $(".unclick_star:gt("+index+")").css("display","inline-block");
    }
    else{
      document.getElementById("starhidden").value = 5;
      $(".click_star:gt("+index+")").css("display", "none");
      $(".unclick_star:gt("+index+")").css("display","inline-block");
    }
  })

  $(".unclick_star").click(function(){
    let index = $(".unclick_star").index(this);
    console.log(index);
    if(index == 0){
      document.getElementById("starhidden").value = 1;
      $(".unclick_star:eq("+index+")").css("display", "none");
      $(".click_star:eq("+index+")").css("display","inline-block");
    }
    else if(index == 1){
      let index2 = index+1;
      document.getElementById("starhidden").value = 2;
      $(".unclick_star:lt("+index2+")").css("display", "none");
      $(".click_star:lt("+index2+")").css("display","inline-block");
    }
    else if(index == 2){
      let index2 = index+1;
      document.getElementById("starhidden").value = 3;
      $(".unclick_star:lt("+index2+")").css("display", "none");
      $(".click_star:lt("+index2+")").css("display","inline-block");
    }
    else if(index == 3){
      let index2 = index+1;
      document.getElementById("starhidden").value = 4;
      $(".unclick_star:lt("+index2+")").css("display", "none");
      $(".click_star:lt("+index2+")").css("display","inline-block");
    }
    else{
      let index2 = index+4;
      document.getElementById("starhidden").value = 5;
      $(".unclick_star:lt("+index2+")").css("display", "none");
      $(".click_star:lt("+index2+")").css("display","inline-block");
    }
  })

  $(".like_unclick").click(function(){
    $(".like_unclick").css("display","none");
    $(".like_click").css("display","inline-block");
    var like_count = $(".like_count").text();
    var num = parseInt(like_count,10);
    num++
    $('.like_count').text(num);
  })
  $(".like_click").click(function(){
    $(".like_click").css("display","none");
    $(".like_unclick").css("display","inline-block");
    var like_count = $(".like_count").text();
    var num = parseInt(like_count,10);
    num--
    $('.like_count').text(num);
  })
  
  $("select[name=menu]").change(function(){
    var menu_data = $("select[name=menu] option:selected").text();
    if(menu_data =="야채튀김"){
      $("#menu1").css("display","inline-block");
    }
    else if(menu_data =="고구마튀김"){
      $("#menu2").css("display","inline-block");
    }
    else if(menu_data =="오징어튀김"){
      $("#menu3").css("display","inline-block");
    }
    else{
      $("#menu4").css("display","inline-block");
    }
  })
  function getTodayType() {
    var date = new Date();
    return date.getFullYear() + "-" + ("0"+(date.getMonth()+1)).slice(-2) + "-" + ("0"+date.getDate()).slice(-2);
  }
})