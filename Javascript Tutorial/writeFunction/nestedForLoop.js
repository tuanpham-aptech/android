// vòng lặp for lồng nhau 
for(var i=0;i<3;i++){
    document.write("<strong> Outer Loop </strong>");
    document.write(i);
    document.write("<br>");
    for(var j = 0; j<5;j++){
        document.write("Inner Loop ");
        document.write(j);
        document.write("<br>");
    }

}
// đối với vòng lặp trên chạy theo logic sau 
/* i = 0 < 3 sẽ chạy vào trong 
    in ra dòng 1 : document.write("<strong> Outer Loop </strong>");
    in ra dòng 2 : document.write(i);
    in ra dòng 3 : document.write("<br>");
    bắt đầu vòng lặp trong 
    j = 0 < 5 nếu vẫn nhỏ hơn 5 tăng j lên 
    In ra 3 dòng liên tục  
    document.write("Inner Loop ");
    document.write(j);
    document.write("<br>");
    cho đến khi j = 5 <5 thì thoát khỏi vòng lặp trong ra vòng lặp ngoài thực hiện như trên 
*/
