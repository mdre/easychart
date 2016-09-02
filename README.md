# EasyChart

# A Vaadin graph wrapper to use C3 and D3 script.

This component has create the necesary elements to let C3 or D3 script to run on. You just need to provide a valid script to the component and it will be runned in the client browser.
Here is an example:

```Java
        final VerticalLayout vlMain = new VerticalLayout();
        vlMain.setMargin(true);
        
        String c3script2 = "c3.generate({\n"
                    + "        bindto: '#chart1',\n"
                    + "//    bindto: '#chart1',\n"
                    + "        data: {\n"
                    + "            columns: [\n"
                    + "                [ 30, 200, 100, 400, 150, 250]\n"
                    + "            ],\n"
                    + "            type: 'bar'\n"
                    + "        },\n"
                    + "        axis: {\n"
                    + "            rotated: true,\n"
                    + "            localtime: true,\n"
                    + "            x: {\n"
                    + "                type: 'category',\n"
                    + "                categories: ['uno','dos','tres','cuatro','cinco','seis']\n"
                    + "               }\n"
                    + "        }\n"
                    + "    })";

            Chart chart = new Chart("chart1",c3script2);
            chart.addStyleName("chart1");

            chart.setWidth("100%");
            chart.setHeight("600px");

            vlMain.addComponent(chart);
            setContent(vlMain);
            
  ```
  
  You must set the ID of the chart and reference it in the script. As you can see in the chart instantiation, "chart1" is defined as the reference.
  Currently I have implemented a few simple chart factory to simplify the chart creation. The available chart are:
  
  * ***horizontaBarChart***:
  
  ```Java
  Chart horizontalBar(String chartID, ArrayList colData, ArrayList<String> categories)
  ```
  
  * ***c3TimeSeries***:
  
  ```Java
  Chart c3TimeSeries(String chartID, DynamicDataSheet data, String timeFormat)
  ```
  
  
  
  work in progress...
