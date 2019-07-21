/*
    vue插件
* */

(function () {

    /*需要暴露给外面的插件对象*/
    var MyPlugin = {};

    MyPlugin.install = function (Vue, options) {
        // 1. 添加全局方法或属性
        Vue.myGlobalMethod = function () {
            console.info("Vue函数对象的myGlobalMethod方法")
        }

        // 2. 添加全局资源
        Vue.directive('my-directive', function (el,binding) {
            el.textContent = binding.value.toUpperCase()
        })

        // 4. 添加实例方法
        Vue.prototype.$myMethod = function () {
            console.info("Vue函数对象的$myMethod方法")
        }
    }
    // 向外暴露
    window.MyPlugin = MyPlugin;
})