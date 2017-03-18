document.write('\
\
  <nav class="navbar navbar-default" role="navigation">\
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
');
var user = JSON.parse(sessionStorage.getItem('user'));
if (sessionStorage.getItem('user') != null) {
    var user = JSON.parse(sessionStorage.getItem('user'));
    document.write('\
    \
        <ul class="nav navbar-nav pull-right">\
              <li><p id="class="navbar-text">Bienvenue </p></li>\
              <li><button type="button" class="btn btn-default navbar-btn" onclick="location.href =\'sign_in.html\'">Deconnexion</button></li>\
          </ul>\
    ');
} else {
    document.write('\
    \
        <ul class="nav navbar-nav pull-right">\
              <li><a href="sign_up.html">Inscription</a></li>\
              <li><button type="button" class="btn btn-default navbar-btn" onclick="location.href =\'sign_in.html\'">Connexion</button></li>\
          </ul>\
    ');
}
document.write('\
\
    </div>\
  </nav>\
');





