var chartDataStr = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataStr);

var arrayLength = chartJsonArray.length;

var numericData = [];
var labelData = [];

for (let i=0; i<arrayLength; i++){
    numericData[i] = chartJsonArray[i].value;
    labelData[i] = chartJsonArray[i].label
}

//For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    // The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#F1948A","#76d7c4","#AED6F1"],
            borderColor: 'rgb(236, 240, 241)',
            data: numericData,
        }]
    },


    // Configuration options go here
    options: {
        title:{
            display:true,
            text : 'Project Status',
        }
    }
});


//[{"value":1,"label":"COMPLETED"},{"value":2,"label":"INPROGRESS"},{"value":1,"label":"NOTSTARTED"}]
function decodeHtml(html){
    let txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}