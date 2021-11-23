document.write("<strong > Difirence between Rest Parameter and Argument Object </strong>");

//create function for Rest Parameter 
function restShow(a,...agrs){
    console.log("a: "+a);
    console.log(agrs);
}
// Calling a function 
restShow(10,20,20,40,50);

// create function Arguments Object 
function show(a){
    console.log("a: "+a);
    console.log(arguments);
}
show(10,20,30,40,50);