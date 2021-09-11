var myArc = {
    x: 50,
    y: 50,
    raio: 15,
    angInicial: 0,
    angFinal: Math.PI * 2,
    canvas: undefined
}

var rect = {
    x: 0,
    y: 50,
    width: 100,
    height: 50
}

var rectReverse = {
    x: 1300,
    y: 120,
    width: 100,
    height: 50
}
/*
var rect3 = {
    x: 0,
    y: 450,
    width: 100,
    height: 50
}

var rect4 = {
    x: 0,
    y: 650,
    width: 100,
    height: 50
}

*/
var EventHandle = function (){
    this.addEvent = function(element, canvas, event, callback){
        switch(event){
            case 'mousedown':
            case 'mouseup':
            case 'mouseover':
            case 'mouseout':
                this.eventMouse(element, canvas, event, callback)
                break;
        }
    }
    this.mouseCanvasCoordinate = function(canvas, e){
        var positionCanvas = canvas.getBoundingClientRect();
        return {
            x: e.clientX - positionCanvas.left,
            y: e.clientY - positionCanvas.top
        };
    }

    this.eventMouse = function(element, canvas, event, callback){
        switch(event){
            case 'mouseover':
                var events = this;
                document.addEventListener('mousemove', function(e){
                    var coordinates = events.mouseCanvasCoordinate(canvas, e);
                    callback(coordinates);
                });
                break;
        }
        
    }
}

function getArc(myArc){
    var cv = document.createElement('canvas');
    cv.width = 100;
    cv.height = 110;
    var context = cv.getContext("2d");
    context.beginPath();
    context.arc(myArc.x, myArc.y, myArc.raio, myArc.angInicial, myArc.angFinal);
    context.fill();

    return cv;
}

function drawArc(myArc){

    if (myArc.canvas == undefined){
        myArc.canvas = getArc(myArc);
    }
    
    var cv = myArc.canvas;
    context.drawImage(cv, myArc.x, myArc.y, cv.width, cv.height);
}

function draw(){
    drawArc(myArc);
}

function drawRect(){
    context.beginPath();
    context.rect(rect.x, rect.y, rect.width, rect.height);
    context.rect(rectReverse.x, rectReverse.y, rectReverse.width, rectReverse.height);

    context.rect(rect.x, rect.y+150, rect.width, rect.height);
    context.rect(rectReverse.x, rectReverse.y+150, rectReverse.width, rectReverse.height);

    context.rect(rect.x, rect.y+300, rect.width, rect.height);
    context.rect(rectReverse.x, rectReverse.y+300, rectReverse.width, rectReverse.height);

    context.rect(rect.x, rect.y+450, rect.width, rect.height);
    context.rect(rectReverse.x, rectReverse.y+450, rectReverse.width, rectReverse.height);

    context.rect(rect.x, rect.y+600, rect.width, rect.height);

    context.fillStyle = 'red';
    context.fill();
    context.lineWidth = 2;
    context.strokeStyle = 'black';
    context.stroke();
}


function animate(time){

    context.clearRect(0,0,canvas.width,canvas.height);
    update();
    update2();
    drawRect();

    draw();

    var eventHandle = new EventHandle();
    eventHandle.addEvent(myArc, canvas, 'mouseover', function(c){
        myArc.x = c.x -50;
        myArc.y = c.y -50;
    });
    window.requestNextAnimationFrame(animate);
}

function update(){
    
    var newX = 0;
    if (reverse){
        newX = rect.x-10;        
        if(newX > 0) {
            rect.x = newX;
            
        } else {
            reverse = false;
        }
    } else {
        newX = rect.x+10;

        if(newX < canvas.width - rect.width) {            
            rect.x = newX;
        } else {
            reverse = true;
        }
    }
}

function update2(){
    
    var newX = 0;
    if (reverse2){
        newX = rectReverse.x-20;        
        if(newX > 0) {
            rectReverse.x = newX;
            
        } else {
            reverse2 = false;
        }
    } else {
        newX = rectReverse.x+20;

        if(newX < canvas.width - rectReverse.width) {            
            rectReverse.x = newX;
        } else {
            reverse2 = true;
        }
    }
}

var canvas = document.getElementById("animation-screen");
canvas.width = window.innerWidth-25;
canvas.height = window.innerHeight-25;
var context = canvas.getContext('2d');
var reverse = false;
var reverse2 = true;


window.requestNextAnimationFrame =  window.requestAnimationFrame
|| window.webkitRequestAnimationFrame
|| window.mozRequestAnimationFrame
|| window.oRequestAnimationFrame
|| window.msRequestAnimationFrame;

animate(+new Date());
