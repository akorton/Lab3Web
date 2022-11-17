$(document).ready(()=>{
   const canvas = document.getElementById("canvas");
   const ctx = canvas.getContext('2d');
   const width = canvas.clientWidth;
   const height = canvas.clientHeight;
   canvas.width = width;
   canvas.height = height;
   const maxCoord = 5;
   const offsetX = 10;
   const offsetY = 10;
   const pointSize = 5;
   const steps = {'x': (width - offsetX) / (2*maxCoord), 'y': (height - offsetY) / (2*maxCoord)};
   const origin = {'x': offsetX / 2 + maxCoord * steps['x'], 'y': offsetY / 2 + maxCoord * steps['y']};
   let x = 0;
   let y = 0;
   let r = 1;
   let points = [];

   let setUp = ()=>{
      ctx.moveTo(origin.x - steps.x * maxCoord, origin.y);
      ctx.lineTo(origin.x + steps.x * maxCoord, origin.y);
      ctx.moveTo(origin.x, origin.y - steps.y * maxCoord);
      ctx.lineTo(origin.x, origin.y + steps.y * maxCoord);
      ctx.stroke();
   };

   let draw = (r)=>{
      ctx.clearRect(0, 0, width, height);
      setUp();
      ctx.fillStyle = '#0000FF';
      drawRect(r);
      drawTriangle(r);
      drawQuaterCircle(r);
   };
   let drawRect = (r)=>{
      ctx.fillRect(origin.x, origin.y, r*steps.x, r*steps.y);
   };
   let drawTriangle = (r)=>{
      ctx.beginPath();
      ctx.moveTo(origin.x, origin.y);
      ctx.lineTo(origin.x - r*steps.x / 2, origin.y);
      ctx.lineTo(origin.x, origin.y - r*steps.y / 2);
      ctx.closePath();
      ctx.fill();
      ctx.stroke();
   };

   let drawQuaterCircle = (r)=>{
      ctx.beginPath();
      ctx.moveTo(origin.x, origin.y);
      ctx.arc(origin.x, origin.y, r*steps.x/2, Math.PI * 3/2, 0);
      ctx.fill();
      ctx.stroke();
   };

   let drawPoint = (x, y, checkResult)=>{
      ctx.fillStyle = checkResult ? '#00FF00' : '#FF0000';
      ctx.beginPath();
      ctx.arc(origin.x + x*steps.x, origin.y - y*steps.y, pointSize, 0, Math.PI * 2);
      ctx.fill();
      ctx.stroke();
   };

   let drawPoints = ()=>{
      draw(r);
      for (let point of points){
         drawPoint(point.x, point.y, point.in);
      }
      drawPoint(x, y, false);
      ctx.beginPath();
   };

   let addToTable = ()=>{
      const table = $('tbody')[0];
      for (const child of [...table.children].slice(1)){
         table.removeChild(child);
      }
      for (const point of points){
         let x = point.x;
         let y = point.y;
         let r = point.r;
         let check = point.in;
         let tr = document.createElement("tr");
         let tdX = document.createElement("td");
         tdX.innerText = x;
         let tdY = document.createElement("td");
         tdY.innerText = y;
         let tdR = document.createElement("td");
         tdR.innerText = r;
         let tdCheck = document.createElement("td");
         tdCheck.innerText = check;
         tr.appendChild(tdX);
         tr.appendChild(tdY);
         tr.appendChild(tdR);
         tr.appendChild(tdCheck);
         table.appendChild(tr);
      }
   }
   drawPoints();
});