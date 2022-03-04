// JavaScript Document
function CoLeeSelect(thisObj){
    var thisinput = thisObj.getElementsByTagName("input");
    var thisul = thisObj.getElementsByTagName("ul");
    var thisli = thisul[0].getElementsByTagName("li");
    if(thisObj.id != "CoLeeSelect"){
        thisObj.id = "CoLeeSelect";
        thisObj.focus();
        thisul[0].style.display = "";
        for(var i=0;i<thisli.length;i++){
            thisli[i].onmouseover = function(){
                for(var j=0;j<thisli.length;j++){
                    thisli[j].className = "";
                }
                this.className = "on";
            }
            thisli[i].onclick = function(){
                thisinput[0].value = this.innerHTML;
            }
        }
    }else{
        ObjBlur();
    }
    thisObj.onblur = ObjBlur;
    function ObjBlur(){
        thisObj.id =  "";
        thisul[0].style.display = "none";
        thisObj.blur();
    }
}