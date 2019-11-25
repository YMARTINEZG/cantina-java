# code-exercise
 End Points

 POST
 Request: /api/count

     http://localhost:8080/api/count

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
 