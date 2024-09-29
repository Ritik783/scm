
// Change theme work start

let currentTheme = getTheme();
changeTheme(currentTheme);

function changeTheme(){
    document.querySelector("html").classList.add(currentTheme);
    let changeButton = document.querySelector('#theme_cahnge_button');
    changeButton.addEventListener("click",(event)=>{
        document.querySelector("html").classList.remove(currentTheme);
        if(currentTheme === "dark"){
            currentTheme='light';
            txt = "Dark"
        }else{
            currentTheme='dark';
            txt = "Light"
        }
        setTheme(currentTheme);
        changeButton.querySelector('span').textContent = txt;
        document.querySelector("html").classList.add(currentTheme);
            
    });

}

function setTheme(theme){
    localStorage.setItem("theme",theme);
}

function getTheme(){
    let theme = localStorage.getItem("theme");
    if(theme){
        return theme;
    }else{
        return "light";
    }
}

// change theme work end
