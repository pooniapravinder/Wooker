
var x, i;
var jl = 0, kl, kk = mp("web_view");
if (kk)
    __bn();

function __bn() {
    kl = kk.getElementsByTagName("a");
    if (kl.length)
        am__bn();
}
function am__bn() {
    setInterval(function () {
        if (kl.length === 1)
            return;
        if (jl === 0) {
            kl[jl].classList.add("animate_out_link");
        }
        if (jl > 0) {
            kl[jl - 1].classList.remove("animate_out_link");
            kl[jl - 1].classList.add("animate_in_link");
            if (jl !== kl.length) {
                kl[jl].classList.add("animate_out_link");
            }
        }
        if (jl > 1) {
            kl[jl - 2].classList.remove("animate_in_link");
        }
        if (jl === kl.length) {
            kl[0].classList.remove("animate_in_link");
            kl[1].classList.remove("animate_in_link");
            jl = 0;
        }
        jl++;

    }, 1000);
}

var xb, ib;
/*look for any elements with the class "custom-select":*/
xb = ml("custom-select");
for (ib = 0; ib < xb.length; ib++) {
    var j, k, a, b, c;
    k = xb[ib].getElementsByTagName("select")[0];
    k.style.display = "none";
    /*for each element, create a new DIV that will act as the selected item:*/
    a = document.createElement("div");
    a.setAttribute("class", "select-selected");
    a.innerHTML = k.options[k.selectedIndex].innerHTML;
    xb[ib].appendChild(a);
    /*for each element, create a new DIV that will contain the option list:*/
    b = document.createElement("div");
    b.setAttribute("class", "select-items select-hide");
    for (j = 0; j < k.length; j++) {
        /*for each option in the original select element,
         create a new DIV that will act as an option item:*/
        c = document.createElement("div");
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
    /*a function that will close all select boxes in the document,
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
document.addEventListener("click", closeAllSelect);

function mp(a) {
    return document.getElementById(a);
}
function ml(a) {
    return document.getElementsByClassName(a);
}