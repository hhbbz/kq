/**
 * @license Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function(config) {

    config.language = 'zh-cn';
    //自定义工具栏 ,大家可以根据需要进行删减
   
	config.image_previewText=' ';
	config.extraPlugins += (config.extraPlugins ? ',lineheight' : 'lineheight');
};