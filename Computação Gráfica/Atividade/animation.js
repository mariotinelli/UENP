var myArc = {
    x: 50,
    y: 50,
    raio: 15,
    angInicial: 0,
    angFinal: Math.PI * 2,
    canvas: undefined
}


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
    context.fillStyle = 'red';
    context.fill();
    context.strokeStyle = 'black';
    context.lineWidth = 2;
    context.stroke()

    return cv;
}

function drawBackground(){
    context.drawImage(sky,0,0, canvas.width, canvas.height);
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


function animate(time){

    context.clearRect(0,0,canvas.width,canvas.height);
    drawBackground();
    draw();

    var eventHandle = new EventHandle();
    eventHandle.addEvent(myArc, canvas, 'mouseover', function(c){
        myArc.x = c.x -50;
        myArc.y = c.y -50;
    });
    window.requestNextAnimationFrame(animate);
}


var canvas = document.getElementById("animation-screen");
canvas.width = window.innerWidth-25;
canvas.height = window.innerHeight-25;
var context = canvas.getContext('2d');
var sky = new Image();
sky.src = "sky.jpg";


window.requestNextAnimationFrame =  window.requestAnimationFrame
|| window.webkitRequestAnimationFrame
|| window.mozRequestAnimationFrame
|| window.oRequestAnimationFrame
|| window.msRequestAnimationFrame;

animate(+new Date());
