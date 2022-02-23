    //从url中获取参数
    function getQueryString(name) { 
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
        var r = window.location.search.substr(1).match(reg); 
        if (r != null) return unescape(r[2]); 
        return null; 
    } 

    var rootUrl = "/api";
    var $step = $("#step");
    var $index = $("#index");
    var id = getQueryString("id");

    $step.step({
        index: 1,
        time: 500,
        title: ["个人信息", "生成类型"]
    });

    $index.text($step.getIndex());

    $("#generate").on("click", function() {
        $('#generate').hide();
        $('#slider').show();
        var slider = new SliderUnlock("#slider",{
                successLabelTip : "验证成功"    
            },function(){
                $.ajax({
                type:"post",
                dataType:"json",
                url:rootUrl + "/plan/generate",
                data:{
                personId:id,
                sex:$("#sex").val(),
                goal:$("#goal").val(),
                health:$("#health").val(),
                training:$("#training").val(),
                strength:$("#strength").val()
                },
                success:function(res){
                    setTimeout('hidden()',200);
                        $("#loadingContainer").show();
                        blower = new LoadingBlower("#loadingContainer");
                        blower.addProgress(100);
                        var times = 0
                        setInterval(function(){
                            times++;
                            var p = $('#percentage').text();
                            if (p == "100%"||times >= 5) {
                                window.location.href = "preview.html?path="+res.data.path;
                                window.clearInterval(timer);
                            }
                        },3000);
                    }
                });
        });
        slider.init();
    });   

    function hidden(){
        $('#slider').hide();
    }