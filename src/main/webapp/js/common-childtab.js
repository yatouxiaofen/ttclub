/*
* tabs子界面引用此文件
* */

/* 调用此方法可以在tabs中新建一个名称为name,内容为content的tab子界面 */
function tabsAdd(name,url){
    var content = '<iframe scrolling="auto" frameborder="0" src="'+url+'" style="width:100%;height:100%;"></iframe>';
    var jq = top.jQuery;
    if(jq('#tabs').tabs('exists',name)){
        jq('#tabs').tabs('select',name);
    }else{
        jq('#tabs').tabs('add',{
            title:name,
            content:content,
            closable:true
        });
    }
}
/* 调用此方法可以关闭当前tabs子界面 */
function tabsClose(){
    var jq = top.jQuery;
    var tab=jq('#tabs').tabs('getSelected');//获取当前选中tabs
    var index = jq('#tabs').tabs('getTabIndex',tab);//获取当前选中tabs的index
    jq('#tabs').tabs('close',index);//关闭对应index的tabs
}