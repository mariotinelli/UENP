var fileLoader = document.getElementById('fileLoader');
var image = document.getElementById('image');
var canvas = document.getElementById('canvas');
var context = null;


let load = function () {
    
    context = canvas.getContext('2d');
    canvas.width = image.width;
    canvas.height = image.height;
    context.drawImage(image, 0, 0);
}

//Grayscale
let grayScaleMean = function() {
    let imageData = context.getImageData(0, 0, canvas.width, canvas.height);
    let img = new MatrixImage(imageData);
    for (var i = 0; i < img.width; i++) {
        for (var j = 0; j < img.height; j++) {
            var pixel = img.getPixel(i,j);
            var gray = (pixel[0] + pixel[1] + pixel[2]) / 3; 
            img.setPixel(i, j, new RGBColor(gray, gray, gray));
        }
    }
    context.putImageData(img.imageData, 0, 0);
}
let grayScaleNTSC = function() {
    let imageData = context.getImageData(0, 0, canvas.width, canvas.height);
    let img = new MatrixImage(imageData);
    for (var i = 0; i < img.width; i++) {
        for (var j = 0; j < img.height; j++) {
            var pixel = img.getPixel(i,j);
            var gray = pixel[0]*0.299 + pixel[1]*0.587 + pixel[2]*0.144
            img.setPixel(i, j, new RGBColor(gray, gray, gray));
        }
    }
    context.putImageData(img.imageData, 0, 0);
}

// Filtros (Media e Mediana)
let medianSuavization = function() {
    let imageData = context.getImageData(0, 0, canvas.width, canvas.height);
    let img = new MatrixImage(imageData);
    for (var i = 1; i < img.width+1; i++) {       
        for (var j = 1; j < img.height+1; j++) {   

            var px = Array();
            px.push(rgbToHsl(img.getPixel(i-1,j-1)));
            px.push(rgbToHsl(img.getPixel(i-1,j)));
            px.push(rgbToHsl(img.getPixel(i-1,j+1)));

            px.push(rgbToHsl(img.getPixel(i,j-1)));
            px.push(rgbToHsl(img.getPixel(i,j)));
            px.push(rgbToHsl(img.getPixel(i,j+1)));

            px.push(rgbToHsl(img.getPixel(i+1,j-1)));
            px.push(rgbToHsl(img.getPixel(i+1,j)));
            px.push(rgbToHsl(img.getPixel(i+1,j-1)));

            var h = Array();
            var s = Array();
            var l = Array();

            for (let index = 0; index < px.length; index++) {
                h.push(px[index][0]);
                s.push(px[index][1]); 
                l.push(px[index][2]); 
            }

            function sortfunction(a, b){
                return (a - b)
            }

            h.sort(sortfunction);
            s.sort(sortfunction);
            l.sort(sortfunction);

            var rgb = HSLToRGB(h[4],s[4],l[4]);

            var red = rgb[0];
            var green = rgb[1];
            var blue = rgb[2];
            img.setPixel(i, j, new RGBColor(red, green, blue));

        }
    }

    context.putImageData(img.imageData, 0, 0);
}
let meanSuavization = function() {
    let imageData = context.getImageData(0, 0, canvas.width, canvas.height);
    let img = new MatrixImage(imageData);
    for (var i = 0; i < img.width; i++) {
        for (var j = 0; j < img.height; j++) {
            var pixel = Array();
            //pegando os pixels do kernel e colocando no array pixel
            pixel.push(img.getPixel(i-1,j-1));
            pixel.push(img.getPixel(i-1,j));
            pixel.push(img.getPixel(i-1,j+1));
            pixel.push(img.getPixel(i,j-1));
            pixel.push(img.getPixel(i,j));
            pixel.push(img.getPixel(i,j+1));
            pixel.push(img.getPixel(i+1,j-1));
            pixel.push(img.getPixel(i+1,j));
            pixel.push(img.getPixel(i+1,j-1));

            var reds = Array();
            var greens = Array();
            var blues = Array();

            for( x = 0; x < pixel.length; x++){
                reds.push(pixel[x][0]);
                greens.push(pixel[x][1]);
                blues.push(pixel[x][2]);
            }

            var red = reds.reduce((a, b) => a + b, 0) / 9;
            var green = greens.reduce((a, b) => a + b, 0) / 9;
            var blue = blues.reduce((a, b) => a + b, 0) / 9;


            img.setPixel(i, j, new RGBColor(red, green, blue));
        }
    }
    context.putImageData(img.imageData, 0, 0);
}

//Renderização
let rend4X = function () {
    let imageData = context.getImageData(0, 0, canvas.width, canvas.height);
    var maxWidth = imageData.width*4;
    var maxHeight = imageData.height*4;
    var width = imageData.width;
    var height = imageData.height;

    if (width > height) {
        if (width < maxWidth) {
            height = height * (maxWidth / width);
            width = maxWidth;
        }
    } else {
        if (height < maxHeight) {
            width = width * (maxHeight / height);
            height = maxHeight;
        }
    }

    imageData.width, canvas.width = width;
    imageData.height, canvas.height = height;
    context.drawImage(image, 0, 0, width, height);
}
let rend2X = function () {
    let imageData = context.getImageData(0, 0, canvas.width, canvas.height);
    var maxWidth = imageData.width*2;
    var maxHeight = imageData.height*2;
    var width = imageData.width;
    var height = imageData.height;

    if (width > height) {
        if (width < maxWidth) {
            height = height * (maxWidth / width);
            width = maxWidth;
        }
    } else {
        if (height < maxHeight) {
            width = width * (maxHeight / height);
            height = maxHeight;
        }
    }

    canvas.width = width;
    canvas.height = height;

    context.drawImage(image, 0, 0, width, height);
}
let rend12 = function () {
    let imageData = context.getImageData(0, 0, canvas.width, canvas.height);
    var maxWidth = imageData.width*0.5;
    var maxHeight = imageData.height*0.5;
    var width = imageData.width;
    var height = imageData.height;

    if (width > height) {
        if (width > maxWidth) {
            height = height * (maxWidth / width);
            width = maxWidth;
        }
    } else {
        if (height < maxHeight) {
            width = width * (maxHeight / height);
            height = maxHeight;
        }
    }

    canvas.width = width;
    canvas.height = height;

    context.drawImage(image, 0, 0, width, height);
}
let rend14 = function () {
    let imageData = context.getImageData(0, 0, canvas.width, canvas.height);
    var maxWidth = imageData.width*0.25;
    var maxHeight = imageData.height*0.25;
    var width = imageData.width;
    var height = imageData.height;

    if (width > height) {
        if (width > maxWidth) {
            height = height * (maxWidth / width);
            width = maxWidth;
        }
    } else {
        if (height < maxHeight) {
            width = width * (maxHeight / height);
            height = maxHeight;
        }
    }

    canvas.width = width;
    canvas.height = height;

    context.drawImage(image, 0, 0, width, height);
}

// Rotação
let rotation90 = function() {

    context.clearRect(0,0,canvas.width,canvas.height);
    context.save();
    canvas.width = image.height;
    canvas.height = image.width;
    context.translate(canvas.width/2,canvas.height/2);
    context.rotate(Math.PI/2);
    context.drawImage(image, -image.width/2, -image.height/2);
    context.restore();
}

let rotation180 = function() {
    context.clearRect(0,0,canvas.width,canvas.height);
    context.save();
    context.translate(canvas.width/2,canvas.height/2);
    context.rotate(180*Math.PI/180);
    context.drawImage(image, -image.width/2, -image.height/2);
    context.restore();
}
let rotation270 = function() {
    
    context.clearRect(0,0,canvas.width,canvas.height);
    context.save();
    canvas.width = image.height;
    canvas.height = image.width;
    context.translate(canvas.width/2,canvas.height/2);
    context.rotate(270*Math.PI/180);
    context.drawImage(image, -image.width/2, -image.height/2);
    context.restore();
}

// Limiar
let limiarização = function(){

    let imageData = context.getImageData(0, 0, canvas.width, canvas.height);
    let img = new MatrixImage(imageData);
    let black = 0;
    let white = 255;
    let threshold = 121;

    for (var i = 0; i < img.width; i++) {
        for (var j = 0; j < img.height; j++) {

            var pixel = Array();

            pixel.push(img.getPixel(i,j));

            var mean = pixel[0][0]*0.299 + pixel[0][1]*0.587 + pixel[0][2]*0.144;

            if(mean < threshold){
                img.setPixel(i,j, new RGBColor(white, white, white));
            }else{
                img.setPixel(i,j, new RGBColor(black, black, black));
            }

        }
    }
    context.putImageData(img.imageData, 0, 0);

}

// Conversões
function HSLToRGB(h,s,l) {
    s /= 100;
    l /= 100;
  
    let c = (1 - Math.abs(2 * l - 1)) * s,
        x = c * (1 - Math.abs((h / 60) % 2 - 1)),
        m = l - c/2,
        r = 0,
        g = 0,
        b = 0;
  
    if (0 <= h && h < 60) {
      r = c; g = x; b = 0;  
    } else if (60 <= h && h < 120) {
      r = x; g = c; b = 0;
    } else if (120 <= h && h < 180) {
      r = 0; g = c; b = x;
    } else if (180 <= h && h < 240) {
      r = 0; g = x; b = c;
    } else if (240 <= h && h < 300) {
      r = x; g = 0; b = c;
    } else if (300 <= h && h < 360) {
      r = c; g = 0; b = x;
    }
  
    r = Math.round((r + m) * 255);
    g = Math.round((g + m) * 255);
    b = Math.round((b + m) * 255);
  
    return new Array(r, g, b);
} 
function rgbToHsl(c) {
    var r = c[0]/255, g = c[1]/255, b = c[2]/255;
    var max = Math.max(r, g, b), min = Math.min(r, g, b);
    var h, s, l = (max + min) / 2;
  
    if(max == min) {
      h = s = 0; // achromatic
    } else {
      var d = max - min;
      s = l > 0.5 ? d / (2 - max - min) : d / (max + min);
      switch(max){
        case r: h = (g - b) / d + (g < b ? 6 : 0); break;
        case g: h = (b - r) / d + 2; break;
        case b: h = (r - g) / d + 4; break;
      }
      h /= 6;
    }
    return new Array(h * 360, s * 100, l * 100);
}

class RGBColor {
    constructor(r, g, b) {
      this.red = r;
      this.green = g; 
      this.blue = b;
    }
}

class MatrixImage {
    constructor(imageData) {
      this.imageData = imageData;
      this.height = imageData.height; 
      this.width = imageData.width;
    }

    getPixel(x, y) {
        let position = ((y * (this.width * 4)) + (x * 4));

        return new Array(
            this.imageData.data[position],   //red
            this.imageData.data[position+1], //green
            this.imageData.data[position+2], //blue
        );

       // return new RGBColor(
       //      this.imageData.data[position],   //red
      //       this.imageData.data[position+1], //green
      //       this.imageData.data[position+2], //blue
      //  );
    }

    setPixel(x, y, color) {
        let position = ((y * (this.width * 4)) + (x * 4));
        this.imageData.data[position] = color.red;
        this.imageData.data[position+1] = color.green;
        this.imageData.data[position+2] = color.blue;
    }
}

document.getElementById('btnLoad').addEventListener('click', load);
document.getElementById('btnGrayMean').addEventListener('click', grayScaleMean);
document.getElementById('btnGrayNTSC').addEventListener('click', grayScaleNTSC);
document.getElementById('btnMean').addEventListener('click', meanSuavization);
document.getElementById('btnMedian').addEventListener('click', medianSuavization);
document.getElementById('btn4x').addEventListener('click', rend4X);
document.getElementById('btn2x').addEventListener('click', rend2X);
document.getElementById('btn12').addEventListener('click', rend12);
document.getElementById('btn14').addEventListener('click', rend14);
document.getElementById('btn90').addEventListener('click', rotation90);
document.getElementById('btn180').addEventListener('click', rotation180);
document.getElementById('btn270').addEventListener('click', rotation270);
document.getElementById('btnLim').addEventListener('click', limiarização);