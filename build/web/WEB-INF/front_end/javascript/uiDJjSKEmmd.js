
var xb, ib;
/*look for any elements with the class "custom-select":*/
xb = ml("custom-select");
mp("lang_style").style.display = "none";
mp("custom-select").style.display = "inline-block";
for (ib = 0; ib < xb.length; ib++) {
    var j, k, a, b, c;
    k = xb[ib].getElementsByTagName("select")[0];
    k.style.display = "none";
    /*for each element, create a new DIV that will act as the selected item:*/
    a = window.document.createElement("div");
    a.setAttribute("class", "select-selected");
    for (var op = 0; op < k.options.length; op++) {
        if (k.options[op].value === mp("lang").value) {
            k.selectedIndex = op;
            break;
        }
    }
    a.innerHTML = k.options[k.selectedIndex].innerHTML;
    xb[ib].appendChild(a);
    /*for each element, create a new DIV that will contain the option list:*/
    b = window.document.createElement("div");
    b.setAttribute("class", "select-items select-hide");
    for (j = 0; j < k.length; j++) {
        /*for each option in the original select element,
         create a new DIV that will act as an option item:*/
        c = window.document.createElement("div");
        c.innerHTML = k.options[j].innerHTML;
        if (k.options[j].selected)
            c.setAttribute("class", "same-as-selected");
        c.addEventListener("click", function () {
            /*when an item is clicked, update the original select box,
             and the selected item:*/
            var y, i, k, s, h;
            s = this.parentNode.parentNode.getElementsByTagName("select")[0];
            h = this.parentNode.previousSibling;
            for (i = 0; i < s.length; i++) {
                if (s.options[i].innerHTML === this.innerHTML) {
                    s.selectedIndex = i;
                    h.innerHTML = this.innerHTML;
                    y = this.parentNode.getElementsByClassName("same-as-selected");
                    for (k = 0; k < y.length; k++) {
                        y[k].removeAttribute("class");
                    }
                    this.setAttribute("class", "same-as-selected");
                    function x(a) {
                        window.document.location.href = a;
                    }
                    var a = window.location.href, b = "lang", c = s.options[s.selectedIndex].value;
                    var re = new RegExp("([?&])" + b + "=.*?(&|$)", "i");
                    var separator = a.indexOf('?') !== -1 ? "&" : "?";
                    if (a.match(re)) {
                        x(a.replace(re, '$1' + b + "=" + c + '$2'));
                    }
                    else {
                        x(a + separator + b + "=" + c);
                    }
                    break;
                }
            }
            h.click();
        });
        b.appendChild(c);
    }
    xb[ib].appendChild(b);
    a.addEventListener("click", function (e) {
        /*when the select box is clicked, close any other select boxes,
         and open/close the current select box:*/
        e.stopPropagation();
        closeAllSelect(this);
        this.nextSibling.classList.toggle("select-hide");
        this.classList.toggle("select-arrow-active");
    });
}
function closeAllSelect(elmnt) {
    /*a function that will close all select boxes in the window.document,
     except the current select box:*/
    var x, y, i, arrNo = [];
    x = ml("select-items");
    y = ml("select-selected");
    for (i = 0; i < y.length; i++) {
        if (elmnt === y[i]) {
            arrNo.push(i);
        } else {
            y[i].classList.remove("select-arrow-active");
        }
    }
    for (i = 0; i < x.length; i++) {
        if (arrNo.indexOf(i)) {
            x[i].classList.add("select-hide");
        }
    }
}
/*if the user clicks anywhere outside the select box,
 then close all select boxes:*/
window.document.addEventListener("click", closeAllSelect);
function mp(a) {
    return window.document.getElementById(a);
}
function ml(a) {
    return window.document.getElementsByClassName(a);
}