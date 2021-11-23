document.write("Hàm ẩn làm đối số của hàm khác ");
function display(param){
    return "Đối số hàm là : "+param;
}
document.write(display(function(){
    return "Phạm Văn Tuân ";
}));