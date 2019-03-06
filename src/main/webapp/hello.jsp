<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-treeview/1.2.0/bootstrap-treeview.min.js"></script>

</head>
<body>
<div id="tree"></div>

</body>
<script>
    var tree_data = [{
        text: "node_1",
        nodes: [{
            text: "node_1_2"
        }, {
            text: "text_node_1_3"
        }]
    },
        {
            text: "node_2",
            nodes: [{
                text: "node_2_3"
            }]
        }
    ]
    $("#tree").treeview({
        data: tree_data,
        levels: 6,
        border: "none"
    });
    $("#tree").on("click", "li", function() {
        console.log(this);
    });
</script>




</html>
