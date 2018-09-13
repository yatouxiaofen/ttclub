function getMenu(){
    $.ajax({
        url:'right/getRightMenu',
        type: 'GET',
        data : {},
        dataType: 'json',
        success:function(data){
            if(data.code=='0000'){
                showMenu(data.object);
            }
        },
        fail:function (XMLHttpRequest, textStatus, errorThrown) {

        }
    });
}

function getUserMenu(){
    $.ajax({
        url:'user/getUserRights',
        type: 'GET',
        data : {},
        dataType: 'json',
        success:function(data){
            if(data.code=='0000'){
                showMenu(data.object);
            }
        },
        fail:function (XMLHttpRequest, textStatus, errorThrown) {

        }
    });
}

function showMenu(object){
    $.each(object,function(i,o)
    {
        if(o.children.length>0) {
            var context = getChildMenus(o);
            $('#menus').accordion('add', {
                title: o.rightName,
                content: context,
                selected: false
            });
        }
    });
    $('#menus').accordion('select',0);
}

function getChildMenus(o){
    var content = '<ul>';
    $.each(o.children, function (i, c) {
        content += "<li>";
        if(c.url){
            content += "<a href=\"javascript:void(0)\" onClick=\"to('"+c.rightName+"','"+c.url+"')\" >";
            content += '<span>'+c.rightName+'</span>';
            content += '</a>';
        }else {
            content += '<span>' + c.rightName + '</span>';
        }
        if(c.children.length>0){
            content += getChildMenus(c);
        }
        content += '</li>';
    });
    content += '</ul>';
    return content;
}

function to(name,url){
    var content = '<iframe scrolling="auto" frameborder="0" src="'+url+'" style="width:100%;height:100%;"></iframe>';
    if($('#tabs').tabs('exists',name)){
        $('#tabs').tabs('select',name);
    }else{
        $('#tabs').tabs('add',{
            title:name,
            content:content,
            closable:true
        });
    }
}