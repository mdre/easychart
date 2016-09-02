/*
 * Variables a usar:
 *      chartId
 *      xlabel
 *      colData
 *      timeFormat
 */
var chartId = c3.generate({
    bindto: '#chartId',
    data: {
        x: 'x',
//        xFormat: '%Y%m%d', // 'xFormat' can be used as custom format of 'x'
        columns: [
            ['x', xlabel],
            colData
//            ['x', '20130101', '20130102', '20130103', '20130104', '20130105', '20130106'],
//            ['data1', 30, 200, 100, 400, 150, 250],
//            ['data2', 130, 340, 200, 500, 250, 350]
        ]
    },
    axis: {
        x: {
            type: 'timeseries',
            tick: {
                format: 'timeFormat' //'%Y-%m-%d'
            }
        }
    }
});

setTimeout(function () {
    chartId.resize();
}, 50);