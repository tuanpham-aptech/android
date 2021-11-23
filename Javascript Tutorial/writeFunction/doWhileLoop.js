/*The do while loop is similar to while loop, but the condition is checked after 
the loop body is executed. This ensure that the loop body is run at least once. 
do{
    statements;
}while(test condition);
*/
var i=0;
do{
document.write(i);
i++;
document.write("<br>");
}while(i<5);