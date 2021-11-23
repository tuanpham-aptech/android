//Phạm vi biến toàn cục trong javascript (global variable)
//Acessiable from anywhere 
var i = "I am Global Variable ";// Global variable
function show(){
    document.write(i + "<br>");// Inside function 
}
// Calling a function 
show();
document.write(i + "<br>");//Outside function 

function disp(){
    document.write(i + "<br>");// Inside function 
}
disp();
if(true){
    document.write(i + "<br>");// Inside function 
}

// Phạm vi biến cục bộ (local variable )
function show(a){
    var b = 10;
    return a+b;
    }
    document.write(show(10)+ "<br>");
    
