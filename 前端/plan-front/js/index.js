	var rootUrl = "/api";
	var $step = $("#step");
	var $index = $("#index");

	$step.step({
		index: 0,
		time: 500,
		title: ["个人信息", "生成类型"]
	});
	// 下一步按钮
	$("#nextBtn").on("click", function() {

		$.ajax({
				type:"POST",
				dataType:"json",
				cache: false,
				url:rootUrl + "/person/collect",
				data:{
				name:$('#name').val(),
				age:$('#age').val(),
				wechat:$('#wechat').val(),
				qq:$('#qq').val(),
				mail:$('#mail').val(),
				phone:$('#phone').val()
				},
				success:function(res){
					console.log(res);
					$step.nextStep();
					$index.text();
					if($step.getIndex()==1){
						window.location.href="generate.html?id="+res.data.id;
					}
				}
		});
				// $step.nextStep();
				// $index.text();
				// if($step.getIndex()==1){
				// 	window.location.href="generate.html?id="
				// }
	}); 