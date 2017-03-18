var xhr = new XMLHttpRequest();
var videolistJson;
xhr.open('GET', 'http://localhost:8080/gudetama/webapi/video/list', true);
xhr.onreadystatechange = function () {//Call a function when the state changes.
    if (xhr.readyState == 4 && xhr.status == 200) {
        videolistJson = JSON.parse(xhr.responseText);
        //alert(videolist[0].category.name);

        $(document).ready(function () {
            var newTitle = document.getElementById('')

            /*for (index in videolistJson) {
                alert("inside for");
                $('#title ul').append('<li><a href ="#" data-maker="' + videolistJson.title[index].maker +'"></a></li>');
            }



            for (var i = 0; i < videolistJson.length; i++) {
                alert("inside second for");
                document.write(videolist[i].title);
                //alert(videolist[i].title);


            }*/
        })
    }
};

xhr.send();