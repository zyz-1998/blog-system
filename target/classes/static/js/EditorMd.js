$(function() {
        editormd("test-editormd", {
            width   : "90%",
            height  : 640,
            syncScrolling : "single",
            //你的lib目录的路径，我这边用JSP做测试的
            tocm : true, // Using [TOCM]
            tex : true, // 开启科学公式TeX语言支持，默认关闭
            flowChart : true, // 开启流程图支持，默认关闭
            path    : "/editormd/lib/",
            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
            saveHTMLToTextarea : true,
            imageUpload : true,
            imageFormats : [ "jpg", "jpeg", "gif", "png", "bmp", "webp" ],
            imageUploadURL : "/uploadimg",
            onload: function () {
                //console.log('onload', this);
                //this.fullscreen();
                //this.unwatch();
                //this.watch().fullscreen();
                this.width("100%");
                this.height(500);
                //this.resize("100%", 640);
            }


        });
        $("#submitBtn").click(
            function () {
                alert("确认提交");
                submitblog();
            }
        )
        function submitblog() {
            var  title = $("#title").val();
            var content = $("#content").val();
            var htmlContent = $("#htmlContent").val();
            var date = new Date();
            var author = "zyz";
            var summary = content.substring(0,100);
            $.ajax({
                url: "submit",
                data: {title: title, content:content, htmlContent:htmlContent, summary: summary, date : date, author : author},
                success:function () {
                    alert("发布成功");
                },
                error:function () {
                    alert("发布失败");
                }
            })
        }

    });