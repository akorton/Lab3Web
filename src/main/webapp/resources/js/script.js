const interval = 11000;

let updateTime = ()=>{
    const updateButton = document.querySelector("input[type=submit]");
    if (updateButton !== undefined && updateButton !== null){
        updateButton.click();
    }
};

setInterval(updateTime, interval);
