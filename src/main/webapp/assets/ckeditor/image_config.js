CKEDITOR.editorConfig = function( config ) {
	config.toolbarGroups = [
		{ name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker', 'editing' ] },
		{ name: 'forms', groups: [ 'forms' ] },
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi', 'paragraph' ] },
		{ name: 'links', groups: [ 'links' ] },
		{ name: 'insert', groups: [ 'insert' ] },
		{ name: 'styles', groups: [ 'styles' ] },
		{ name: 'colors', groups: [ 'colors' ] },
		{ name: 'tools', groups: [ 'tools' ] },
		{ name: 'others', groups: [ 'others' ] },
		{ name: 'about', groups: [ 'about' ] }
	];
	config.removeButtons = 'Save,NewPage,Copy,Templates,Cut,Undo,Redo,Paste,PasteText,PasteFromWord,Print,Preview,Find,Replace,Scayt,SelectAll,Form,Checkbox,Radio,TextField,Textarea,Select,Button,ImageButton,HiddenField,Bold,CopyFormatting,Italic,RemoveFormat,Underline,Strike,Subscript,Superscript,NumberedList,BulletedList,Indent,Outdent,Blockquote,CreateDiv,JustifyCenter,JustifyRight,JustifyBlock,Language,BidiRtl,BidiLtr,JustifyLeft,Link,Unlink,Anchor,Table,Flash,HorizontalRule,Smiley,SpecialChar,PageBreak,Iframe,FontSize,Font,Format,Styles,TextColor,BGColor,ShowBlocks,Maximize,About';
	config.language = 'zh-cn';
};