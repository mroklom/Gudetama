var serverAddr = 'http://localhost:8080';
if (sessionStorage.length == 0)
    document.getElementById('navbar').innerHTML = '\
    <div class="navbar-header">\
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">\
            <span class="icon-bar"></span>\
            <span class="icon-bar"></span>\
            <span class="icon-bar"></span>\
        </button>\
        <a class="navbar-brand" href="index.html">Gudetama France</a>\
    </div>\
    <div class="navbar-collapse collapse">\
        <ul class="nav navbar-nav navbar-left">\
            <li><a href="episodes_list.html">Episodes</a></li>\
            <li><a href="about.html">A propos</a></li>\
        </ul>\
        <ul class="nav navbar-nav pull-right">\
            <li><a href="sign_up.html">Inscription</a></li>\
            <li><button type="button" class="btn btn-default navbar-btn" onclick="location.href =\'sign_in.html\'">Connexion</button></li>\
        </ul>\
    </div>\
';
else
    document.getElementById('navbar').innerHTML = '\
        <div class="navbar-header">\
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">\
                <span class="icon-bar"></span>\
                <span class="icon-bar"></span>\
                <span class="icon-bar"></span>\
            </button>\
            <a class="navbar-brand" href="index.html">Gudetama France</a>\
        </div>\
        <div class="navbar-collapse collapse">\
            <ul class="nav navbar-nav navbar-left">\
                <li><a href="episodes_list.html">Episodes</a></li>\
                <li><a href="bookmarks.html">Vidéos Favories</a></li>\
                <li><a href="about.html">A propos</a></li>\
            </ul>\
            <ul class="nav navbar-nav pull-right">\
                <li><a href="account-settings.html">Mon compte</a></li>\
                <li><button type="button" class="btn btn-danger navbar-btn" onclick="deconnexion()">Deconnexion</button></li>\
            </ul>\
        </div>\
';

function deconnexion() {
    sessionStorage.clear();
    window.location.href = 'index.html';
}
