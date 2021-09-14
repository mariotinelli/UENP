var myRect = {
    x: 50,
    y: 50,
    width: 50,
    height: 50,
    canvas: undefined
}

var createArc = {
    x: 50,
    y: 200,
    raio: 35,
    angInicial: 0,
    angFinal: Math.PI * 2
}

var createArcReverse = {
    x: 1380,
    y: 350,
    raio: 35,
    angInicial: 0,
    angFinal: Math.PI * 2
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

function getRect(myRect){
    var cv = document.createElement('canvas');
    cv.width = 100;
    cv.height = 110;
    var context = cv.getContext("2d");
    context.beginPath();
    context.fillStyle = 'green';
    context.rect(myRect.x, myRect.y, myRect.width, myRect.height);
    context.fill();

    return cv;
}

function drawRect(myRect){

    if (myRect.canvas == undefined){
        myRect.canvas = getRect(myRect);
    }
    
    var cv = myRect.canvas;
    context.drawImage(cv, myRect.x, myRect.y, cv.width, cv.height);
}

function draw(){
    drawRect(myRect);
}

function drawArcs(){
    context.beginPath();
    context.fillStyle = 'black';
    context.arc(createArc.x, createArc.y, createArc.raio, createArc.angInicial, createArc.angFinal);
    context.fill();

    context.beginPath();
    context.fillStyle = 'red';
    context.lineWidth = 2;
    context.strokeStyle = 'black';
    context.arc(createArcReverse.x, createArcReverse.y, createArcReverse.raio, createArcReverse.angInicial, createArcReverse.angFinal);
    context.fill();
    context.stroke();
}

function drawBackground(){
    context.drawImage(sky,0,0, canvas.width, canvas.height);
}

function animate(time){

    context.clearRect(0,0,canvas.width,canvas.height);
    drawBackground();
    draw();
    update();
    updateY();
    update2();
    update2Y();
    drawArcs();
   

    var eventHandle = new EventHandle();
    eventHandle.addEvent(myRect, canvas, 'mouseover', function(c){
        myRect.x = c.x -75;
        myRect.y = c.y -75;
    });
    window.requestNextAnimationFrame(animate);
}

function update(){
    
    var newX = 0;
    if (reverse){
        newX = createArc.x-15;    
        if(newX > 25) {
            createArc.x = newX;
            
        } else {
            reverse = false;
        }
    } else {
        newX = createArc.x+10;
        if(newX < canvas.width - 25) {            
            createArc.x = newX;
        } 
        else {
            reverse = true;
        }
    }
}

function updateY(){
    
    var newY = 0;
    if (reverseY){
        newY = createArc.y-10;      
        if(newY > 25) {
            createArc.y = newY;
            
        } else {
            reverseY = false;
        }
    } else {
        newY = createArc.y+10; 
        if (newY < canvas.height - 25){
            createArc.y = newY;
        }
        else {
            reverseY = true;
        }
    }
}

function update2(){
    
    var newX = 0;
    if (reverse2){
        newX = createArcReverse.x-15;        
        if(newX > 0) {
            createArcReverse.x = newX;
            
        } else {
            reverse2 = false;
        }
    } else {
        newX = createArcReverse.x+10;

        if(newX < canvas.width - 25) {            
            createArcReverse.x = newX;
        } else {
            reverse2 = true;
        }
    }
}

function update2Y(){
    
    var newY = 0;
    if (reverse2Y){
        newY = createArcReverse.y-10;      
        if(newY > 25) {
            createArcReverse.y = newY;
            
        } else {
            reverse2Y = false;
        }
    } else {
        newY = createArcReverse.y+10; 
        if (newY < canvas.height - 25){
            createArcReverse.y = newY;
        }
        else {
            reverse2Y = true;
        }
    }
}

var canvas = document.getElementById("animation-screen");
canvas.width = window.innerWidth-25;
canvas.height = window.innerHeight-25;
var context = canvas.getContext('2d');
var sky = new Image();
sky.src = "sky.jpg";
var reverse = false;
var reverseY = false;
var reverse2 = true;
var reverse2Y = true;


window.requestNextAnimationFrame =  window.requestAnimationFrame
|| window.webkitRequestAnimationFrame
|| window.mozRequestAnimationFrame
|| window.oRequestAnimationFrame
|| window.msRequestAnimationFrame;

animate(+new Date());
