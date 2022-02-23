var rootUrl = "/api";

//从url中获取参数
function getQueryString(name) { 
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
        var r = window.location.search.substr(1).match(reg); 
        if (r != null) return unescape(r[2]); 
        return null; 
} 

var filePath = "./plan" + getQueryString("path");
var fileName_all = "健身计划-全套.rar";
var fileName_readme = "必读手册.pdf";
var fileName_training = "训练计划.pdf";
var fileName_diet = "饮食计划.pdf";
var fileName_work = "作息计划.pdf";

// 必读手册
$('#readme-preview').on("click",function(){
    if(PDFObject.supportsPDFs){
    // PDF嵌入到网页
    $('#readme-pic').hide();
    $('#readme-pdf').show();
    PDFObject.embed(filePath + "必读手册.pdf", "#readme-pdf");
    } else {
    $('#readme-pdf-backup').show();    
    alert("亲亲,当前浏览器暂不支持pdf预览,建议您使用PC端进行预览或直接下载到本地查看!");
    }
});

$('#readme-download').on("click",function(){
    window.location.href=rootUrl + "/plan/download?path=" + getQueryString("path") + "&name=" + fileName_readme;
});


//训练计划
$('#training-preview').on("click",function(){
    if(PDFObject.supportsPDFs){
    // PDF嵌入到网页
    $('#training-pic').hide();
    $('#training-pdf').show();
    PDFObject.embed(filePath + "训练计划.pdf", "#training-pdf" );
    } else {
    alert("亲亲,当前浏览器暂不支持pdf预览,建议您使用PC端进行预览或直接下载到本地查看!");
    }
});

$('#training-download').on("click",function(){
    window.location.href=rootUrl + "/plan/download?path=" + getQueryString("path") + "&name=" + fileName_training;
});

// 饮食计划
$('#diet-preview').on("click",function(){
    if(PDFObject.supportsPDFs){
    // PDF嵌入到网页
    $('#diet-pic').hide();
    $('#diet-pdf').show();
    PDFObject.embed(filePath + "饮食计划.pdf", "#diet-pdf" );
    } else {
    alert("亲亲,当前浏览器暂不支持pdf预览,建议您使用PC端进行预览或直接下载到本地查看!");
    }
});

$('#diet-download').on("click",function(){
    window.location.href=rootUrl + "/plan/download?path=" + getQueryString("path") + "&name=" + fileName_diet;
});

//作息计划
$('#work-preview').on("click",function(){
    if(PDFObject.supportsPDFs){
    // PDF嵌入到网页
    $('#work-pic').hide();
    $('#work-pdf').show();
    PDFObject.embed(filePath + "作息计划.pdf", "#work-pdf" );
    } else {
    alert("亲亲,当前浏览器暂不支持pdf预览,建议您使用PC端进行预览或直接下载到本地查看!");
    }
});

$('#work-download').on("click",function(){
    window.location.href=rootUrl + "/plan/download?path=" + getQueryString("path") + "&name=" + fileName_work;
});

//全部文件
    $("#download").on("click",function(){
        window.location.href=rootUrl + "/plan/download?path=" + getQueryString("path") + "&name=" + fileName_all;
    });

 