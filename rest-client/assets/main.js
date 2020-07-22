$(function () {

    $(".btn-get").click(function () {
        console.log("GET");
        delContent("out_get");
        get_rest();
    });
    $(".btn-create").click(function () {
        if($("#name").val()===''){
            $("#name").attr("placeholder", "Заполните 'Лекарственный препарат'!").css({"border":"5px solid red"});
        }else {
            delContent("out_add");
            let name = $("#name").val();
            let param = [name, $("#formRelease").val(), $("#chiper").val(), $("#ibd").val()];
            console.log(param);
            post_rest(param);
        }
    });
    $(".btn-update").click(function () {
        if($("#change").val()===''){
            $("#change").attr("placeholder", "Заполните ID").css({"border":"5px solid red"});
        }else {
        delContent("out_change");
        var url = 'http://localhost:8080/app/rest/v2/entities/medications_MedicationEntity/'+$("#change").val();
        var settings = {
            "async": true,
            "crossDomain": true,
            "url": url,
            "method": "PUT",
            "headers": {
              "authorization": "Bearer "+ oauthToken,
              "content-type": "application/x-www-form-urlencoded",
            },
            "data": $("#form-cange").serializeFormJSON()
        }
        console.log(settings);
        $.ajax(settings).done(function (response) {
            $("#out_change").append("<strong>Сущность успешно изменена</strong>")
            .after("<div class='example'>Пример простого запроса на изменение сущности по id. метод <strong>PUT</strong>:"+
                          "</br><div class='url'><strong>url: </strong>"+settings.url+"</div>"+
                                    "<div class='h'><strong>headers:</strong>'Authorization': 'Bearer " + oauthToken+
                                              ",'Content-Type': 'application/x-www-form-urlencoded'</div><div class='body'><strong>body</strong>{\"medicationName\":\"test\", \"formRelease\":\"test\", \"cipher\":\"test\", \"idb\": \"2020-07-22 00:00\"}</div></div>");
            console.log(response);
        });

        }
    });
    $(".btn-delete").click(function () {
        if($("#del").val()===''){
            $("#del").attr("placeholder", "Заполните ID").css({"border":"5px solid red"});
        }else {
            $("#out_del").text("");
            var settings = {
              "async": true,
              "crossDomain": true,
              "url": "http://localhost:8080/app/rest/v2/entities/medications_MedicationEntity/"+$("#del").val(),
              "method": "DELETE",
              "headers": {
                "authorization": "Bearer "+ oauthToken,
                "content-type": "application/x-www-form-urlencoded",
              }
            }

            $.ajax(settings).done(function (response) {
            $("#out_del").text("");
                $("#out_del").append("<strong>Сущность успешно удалена</strong>")
                            .after("<div class='example'>Пример простого запроса на изменение сущности по id. метод <strong>DELETE</strong>:"+
                                          "</br><div class='url'><strong>url: </strong>"+settings.url+"</div>"+
                                                    "<div class='h'><strong>headers:</strong>'Authorization': 'Bearer " + oauthToken+
                                                              ",'Content-Type': 'application/x-www-form-urlencoded'</div></div>");
                console.log(response);
            });
            if($("#out_del").text()=="") $("#out_del").append("<strong>Такого id не существует или сущность уже была удалена</strong>")
        }
    });
    $("#name").click(function () {
        $(this).attr("placeholder", "").css({"border":"1px solid lightgrey"});
    });
    $("#change").click(function () {
        $(this).attr("placeholder", "").css({"border":"1px solid lightgrey"});
    });
    $("#del").click(function () {
        $(this).attr("placeholder", "").css({"border":"1px solid lightgrey"});
    });
    $.fn.serializeFormJSON = function () {
        var s ="{";
        var a = this.serializeArray();
        $.each(a, function () {
            if(!this.value==""){
                if(this.name=="ibd") this.value= this.value+" 00:00:00.000"
                s+="\""+this.name+"\":\""+this.value+"\",";
            }
        });
        return s.slice(0, s.length-1)+"}";
    };
});
function delContent(idif){
   var idOut=$("#"+idif);
       idOut.next().text("");
      idOut.text("");
}
var oauthToken = null;
function get_rest(){
  $.get({
        url: 'http://localhost:8080/app/rest/v2/services/medications_RestControllerService/getListEntity',
        headers: {
            'Authorization': 'Bearer ' + oauthToken,
            'Content-Type': 'application/json'
        },
        success: function (data) {
            $('#get_head').show();
            $.each(data, function (i, obj) {
                $('#out_get').append("<tr><td>" + obj['name'] + "</td><td>"+ obj['frel'] + "</td><td>" + obj['id'] + "</td></tr>")
            });
            var url = 'http://localhost:8080/app/rest/v2/entities/medications_MedicationEntity/?view=full';
            $("#out_get").after("<div class='example'>Пример простого запроса получение списка сущностей. метод <strong>GET</strong>:"+
                                        "</br><div class='url'><strong>url: </strong>"+url+"</div>"+
                                                  "<div class='h'><strong>headers:</strong>'Authorization': 'Bearer " + oauthToken+
                                                              ",'Content-Type': 'application/json'</div></div>");
        }
    });
}
function post_rest(param){
    var settings = {
      "async": true,
      "crossDomain": true,
      "url": "http://localhost:8080/app/rest/v2/services/medications_RestControllerService/createEntity",
      "method": "POST",
      "headers": {
        "authorization": "Bearer "+ oauthToken,
        "content-type": "application/json",
        "cache-control": "no-cache"
      },
      "processData": false,
      "data": "{\"object\":["+param+"]}"
    }

    $.ajax(settings).done(function (response) {
        var url = 'http://localhost:8080/app/rest/v2/entities/medications_MedicationEntity'
        $('#out_add').text("id сущности:"+response.id)
        .after("<div class='example'>Пример простого запроса на создание. метод <strong>POST</strong>:</br><div class='url'><strong>url: </strong>"+url+"</div>"+
                        "<div class='h'><strong>headers:</strong>'Authorization': 'Bearer " + oauthToken+
                        ",'Content-Type': 'application/json'</div><div class='body'><strong>body</strong>{\"medicationName\":\"test\", \"formRelease\":\"test\", \"cipher\":\"test\", \"idb\": \"2020-07-22\"}</div></div>");

        console.log(response);
    });
}
function login() {
    var userLogin = $('#login').val();
    var userPassword = $('#pwd').val();
    $.post({
        url: 'http://localhost:8080/app/rest/v2/oauth/token',
        headers: {
            'Authorization': 'Basic Y2xpZW50OnNlY3JldA==',
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        dataType: 'json',
        data: {grant_type: 'password', username: userLogin, password: userPassword},
        success: function (data) {
            oauthToken = data.access_token;

			$(".main").show();
            $('.autorisition').remove();

        }
    });
}