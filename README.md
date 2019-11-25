# Cantina coding challenge
the app is a spring boot project that expose 2 endpoint :
1. load the json - parse the json and create a view composite including all child views
2. count views according with selectors 

 End Points 
 
 POST
 Request: api/load
 http://localhost:8080/api/load
 
 payload:
 
 https://github.com/jdolan/quetoo/blob/master/src/cgame/default/ui/settings/SystemViewController.json
 
 
 POST
 Request: /api/count
 http://localhost:8080/api/count

The program must support simple selectors for the following view attributes: 
 
class - The view class name, e.g. "StackView"
classNames - CSS class names, e.g. ".container"
identifier - The view identifier, e.g. "#videoMode"


1.
 payload:
     [{"selectorType":"classView", "selectorValue”:”Input”}]

 Response:
 [
     {
         "selectorType": "classView",
         "selectorValue": "Input",
         "selectorResult": 26
     }
 ]

2.
 payload:
 [{"selectorType":"classNames", "selectorValue":"container"}]

 response:
 [
     {
         "selectorType": "classNames",
         "selectorValue": "container",
         "selectorResult": 6
     }
 ]

3.
 payload:
 [{"selectorType":"identifier", "selectorValue":"videoMode"}]

 response:
 [
    {
        "selectorType": "identifier",
        "selectorValue": "videoMode",
        "selectorResult": 1
    }
 ]

4.
 payload:
 [{"selectorType":"classView", "selectorValue":"StackView"},{"selectorType":"classNames", "selectorValue":"column"}]

 response:
 [
     {
         "selectorType": "classView",
         "selectorValue": "StackView",
         "selectorResult": 6
     },
     {
         "selectorType": "classNames",
         "selectorValue": "column",
         "selectorResult": 3
     }
 ]

5.
 payload:
 [{"selectorType":"classView", "selectorValue":"StackView"},{"selectorType":"classNames", "selectorValue":"container"}]

 response:
 [
     {
         "selectorType": "classView",
         "selectorValue": "StackView",
         "selectorResult": 6
     },
     {
         "selectorType": "classNames",
         "selectorValue": "container",
         "selectorResult": 6
     }
 ]
 
