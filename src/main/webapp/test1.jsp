<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>菜鸟教程(runoob.com)</title>
</head>
<body>

<button id="button1">现在的时间是?</button>
<p id="demo"></p>

</body>
<script>

    $(document).ready(function() {
        $("#button1").bind({
            click: function () {
                alert("11");
            },

            mouseout: function () {
                $('#demo').innerHTML = Date()
            }
    });
    });


</script>
</html>
