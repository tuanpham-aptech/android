/* Default Parameter in javascript Tham số mặc định của javascript  
Syntax:
function function name(params1,params2,params3="value") {
    Block of Statement ;
}
*/
// function add(a,b,c=70){
//     document.write("A : "+a+"<br>");
//     document.write("B : "+b+"<br>");
//     document.write("C : "+c+"<br>");

// }
// add(10,20);
// function add(num,c=[10]){
//     document.write("Number : "+c[0]+"<br>");
//     document.write("Number 1: "+num);
// }
// add(100,[8]);

//Rest Parameter
function show(a,b,...args){
    document.write(a,args[2]);// lúc này mảng nó sẽ bỏ 2 ví trí a, b đi vậy
    // khi hàm in ra thì nó sẽ in ra từ vị trí số 30 là vị trí 0 40 là 1 50 là 2 
    // và kết quả là 10 và 50 dc in ra 
}
show(10,20,30,40,50);