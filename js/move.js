/**
 * 
 */
function getStyle(obj, attr) {
    if (window.getComputedStyle)
        return getComputedStyle(obj, null)[attr];
    else return obj.currentStyle[attr];
}
function getSdouble(obj, attr) {
    return parseFloat(getStyle(obj, attr));
}
var speed = 10;
var delay=17;
var ok = false;
function move(target, obj, callback) {
    clearInterval(obj.timer);
    obj.timer = setInterval(function () {
        var fns = true;
        for (key in target) {
               
            var now = getSdouble(obj, key);
            var tgt = parseFloat(target[key]);
            if (ok) speed = ((tgt > now) ? speed : -speed);
            else speed = (tgt - now) / delay;
            if(key=='opacity')speed*=100;
            if (speed < 0) speed = Math.floor((speed * 10)) / 10;
            else speed = Math.ceil((speed * 10)) / 10;
            if(key=='opacity')now=now*100+speed;
            else now += speed;
            fns &= (now == tgt);
            if(key=='opacity'){
            obj.style[key] = now/100;
         
        }
            else obj.style[key] = now + 'px';
          
        }
        if (fns) {
            console.log("FNS");
            clearInterval(obj.timer);
            if (callback) callback();
        }
    }, 60);

}


 