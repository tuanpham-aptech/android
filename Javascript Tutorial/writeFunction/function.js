// function are subprograms which are used to compute on value or perform a task.
//How to create and call function in Javascript cách tạo hàm và gọi hàm 
// How to create a function 
// function display(){
//     document.write("My name is Tuan.<br>");
//     document.write("I'm 22 years old.");
// }
// Calling a function 
// display();
// function rename(name){
//     document.write(name);
// }
// rename("Phạm Văn Tuân ");
// rename("<br>"+12);
// rename(true);
// // function argument missing 
// function add(a,b,c){
//     document.write("A :"+a+"B :"+b+"C :"+c);
// }
// add(10,20);
function argumentObject(arO1,arO2){
    // document.write(arO1);
    // document.write(arO2);
    // document.write(arguments[0]+" - ");
    // document.write(arguments[1]+" ");
   for(var i =0; i<arguments.length;i++){
       document.write(arguments[i] +" ");// in ra các tham số truyền vào hàm 
   }
}
// Calling function in javascript 
argumentObject("Tuan","Tinh","Dien");
// Too many function Argument in javascript 
function add(a,b){
    document.write("A :"+a+"B :"+b+"C :"+arguments[2]);
}
add("Tuan","Pham","Anh");