$(document).ready(
    function (){
        $(".question-bar").bind().mouseenter(setRawStatistic);

        $(".question-bar").bind().mouseenter(setBarChartTitle);
        $(".question-bar").bind().mouseenter(setBarChartData);
        $(".question-bar").bind().mouseenter(setBarChartCategories);
        $(".question-bar").bind().mouseenter(printBarCharts);

        $(".question-bar").bind().mouseenter(setPieChartTitle);
        $(".question-bar").bind().mouseenter(setPieChartData);
        $(".question-bar").bind().mouseenter(printPieCharts);

        $(".question-bar").mouseenter(
            function (){
                $(this).css("background-color", "#c3e1f51e");   
            }
        );
        $(".question-bar").bind().mouseleave(resetRawStatistic);
        $(".question-bar").mouseleave(
            function (){
                $(this).css("background-color", "white");
            }
        )
    }
);


var raw_statistic = new Array(); //原始数据数组
function setRawStatistic(){
    var option_table = $(this).find(".option-table");
    option_table.find("tr").each(
        function (){
            var tmp = $(this).find("td:last p").text();
            console.log("setRawStatistic:"+tmp);
            raw_statistic.push(+tmp);
        }
    )
    console.log("raw_statistic_length:"+raw_statistic.length);
}
function resetRawStatistic(){
    raw_statistic = [];
}
/* demonstrate bar chart  */
var barChartOptions = {
	chart: {
		type: 'bar'                          //指定图表的类型，默认是折线图（line）
	},
	title: {
		text: '标题'                 // 标题
	},
	xAxis: {
		categories: ['选项1', '选项2', '选项3', '选项4']   // x 轴分类
	},
	yAxis: {
		title: {
			text: '票数'                // y 轴标题
		}
	},
	series: [{                              // 数据列
		name: '票数',                        // 数据列名
		data: [1, 1, 4, 2]                     // 数据
	}]
};
// 图表初始化函数

function printBarCharts(){
    $('#bar-chart').highcharts(barChartOptions);
}

//数据初始化函数
function setBarChartData(){
    console.log("setBarChartData:before:"+barChartOptions.series[0].data);
    barChartOptions.series[0].data = raw_statistic;
    console.log("setBarChartData:after:"+barChartOptions.series[0].data);
}

function setBarChartTitle(){
    var questionNo = $(this).find(".questionNo").text();
    barChartOptions.title.text = "第"+questionNo+"题";
}

function setBarChartCategories(){
    var categories = [];
    var i = 1;
    raw_statistic.forEach(
        function () {
            categories.push("选项"+i);
            i = +i + 1;
        }
    )
    barChartOptions.xAxis.categories = categories;
}





/* demonstrate pie chart */
var chart = null;
pieChartOptions = {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        spacing : [100, 0 , 40, 0]
    },
    title: {
        floating:true,
        text: '圆心显示的标题'
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) 
                }
            },
            point: {
                events: {
                    mouseOver: function(e) {  // 鼠标滑过时动态更新标题
                        // 标题更新函数，API 地址：https://api.hcharts.cn/highcharts#Chart.setTitle
                        chart.setTitle({
                            text: e.target.name+ ':\t'+ 100*e.target.y + ' %'
                        });
                    }
                    //, 
                    // click: function(e) { // 同样的可以在点击事件里处理
                    //     chart.setTitle({
                    //         text: e.point.name+ '\t'+ e.point.y + ' %'
                    //     });
                    // }
                }
            },
        }
    },
    series: [{
        type: 'pie',
        innerSize: '80%',
        name: '占比',
        data: [
            ['选项1', 0.65],
            ['选项2', 0.12],
            ['选项3', 0.03],
            ['选项4', 0.20]
        ]
    }]
}
//图表初始化函数
function printPieCharts(){
    $('#pie-chart').highcharts(pieChartOptions, function(c) {
        // 环形图圆心
        var centerY = c.series[0].center[1],
            titleHeight = parseInt(c.title.styles.fontSize);
        c.setTitle({
            y:centerY + titleHeight/2
        });
        chart = c;
    });
}

//数据初始化函数
function setPieChartTitle(){
    var questionNo = $(this).find(".questionNo").text();
    pieChartOptions.title.text = "第"+questionNo+"题";
}

function setPieChartData(){
    var data = [];
    var sum = +0,i;
    for(i = 0; i < raw_statistic.length; i++){
        sum = sum + raw_statistic[i];
    }
    raw_statistic.forEach(
        function (item, index){
            var data_pair = ['选项'+(+index+1), item/sum];
            data.push(data_pair);
        }
    )
    
    pieChartOptions.series[0].data = data;
    console.log("data"+pieChartOptions.series[0].data);
}