
document.write("<b>Vòng lặp do while lồng nhau</b> <br>");
var i = 0;
do{
    document.write("<strong>Outer Loop </strong>");
    document.write(i);
    i++;
    document.write("<br>");
    var j =0;
    do{
        document.write("Inner Loop ");
        document.write(j);
        j++;
        document.write("<br>");
    }while(j<5);
}while(i<3);