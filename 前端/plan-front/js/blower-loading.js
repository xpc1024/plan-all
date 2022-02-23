"use strict";
/*
 Author: Jafar Akhondali
 Company: DioStudio
 Release date: 2016, 24 Jul
 Title:  Jquery plugin + svg animated loading bar
 Design idea:
 Thanks to @joomlachannel
 */
var Leaf = (function () {
    function Leaf(progress) {
        this.progress = 1;
        this.progress = progress;
    }
    Leaf.getNewLeaf = function (progress) {
        if (progress === void 0) { progress = 1; }
        /*let div = document.createElement("div");
         div.className="leaf";
         return div;
         */
        return $("<div class='leaf'></div>");
    };
    return Leaf;
}());
var LoadingBlower = (function () {
    function LoadingBlower(selector, callback) {
        this.intervalValue = 0;
        this.fillerWidth = 0;
        this.leafCount = 0;
        this.progress = 0;
        this.calllback = callback;
        this.blowerDom = $(selector);
        this.filler = $(this.blowerDom.find(".filler")[0]);
        this.markerContainer = this.blowerDom.find(".marker_container");
        this.loadingBar = this.blowerDom.find(".loadingbar");
        this.progressDom = this.blowerDom.find(".value");
        this.leafObjects = new Array();
    }
    LoadingBlower.prototype.createAndMoveLeaf = function () {
        var _this = this;
        setTimeout(function () {
            var leaf = Leaf.getNewLeaf();
            _this.leafObjects.push(leaf);
            _this.loadingBar.append(leaf);
            $(leaf).css({
                'transform': 'rotate(' + (Math.random() > 0.5 ? '-' : '+') + '195deg)',
                'animation': (Math.random() > 0.5 ? 'wind' : 'wind-up') + ' 3s infinite ease-in-out'
            });
        }, 10);
    };
    LoadingBlower.prototype.addLeaf = function () {
        var _this = this;
        if (this.leafCount > 0) {
            var timeOut = 80 + Math.random() * 100;
            setTimeout(function () {
                _this.createAndMoveLeaf();
                _this.leafCount--;
                _this.addLeaf();
            }, timeOut);
        }
    };
    LoadingBlower.prototype.setProgress = function (progress) {
        var diff = progress - this.progress;
        this.addProgress(diff);
    };
    LoadingBlower.prototype.addProgress = function (dif) {
        if (this.progress === 100)
            return;
        var progress = dif + this.progress > 100 ? 100 : dif + this.progress;
        var degs = progress * -30;
        if (dif > 0) {
            this.leafCount += dif;
            this.rotate(this.markerContainer, degs);
            this.progress = progress;
            this.addLeaf();
            this.intervalValue == 0 ? this.intervalCheck() : 0;
        }
    };
    LoadingBlower.prototype.intervalCheck = function () {
        var _this = this;
        this.intervalValue = setInterval(function () {
            for (var i = 0; i < _this.leafObjects.length; i++) {
                if (parseInt(_this.leafObjects[i].offset().left) <= parseInt(_this.filler.offset().left) + parseInt(_this.filler.width())) {
                    _this.fillerWidth += 1;
                    _this.filler.css('width', _this.fillerWidth + "%");
                    //this.filler.css('width', '+=1%');
                    if(_this.fillerWidth>100){
                       _this.fillerWidth=100 
                    }
                    _this.progressDom.html(_this.fillerWidth + "%");
                    //this.progressDom.html('width','+=1%');
                    if (_this.leafObjects.length === 0) {
                        clearInterval(_this.intervalValue);
                        _this.intervalValue = 0;
                        break;
                    }
                    _this.leafObjects[i].hide();
                    _this.leafObjects.splice(i, 1);
                }
            }
        }, 50);
    };
    LoadingBlower.prototype.rotate = function (el, degrees) {
        el.css({
            '-webkit-transform': 'rotate(' + degrees + 'deg)',
            '-moz-transform': 'rotate(' + degrees + 'deg)',
            '-ms-transform': 'rotate(' + degrees + 'deg)',
            '-o-transform': 'rotate(' + degrees + 'deg)',
            'transform': 'rotate(' + degrees + 'deg)',
            'zoom': 1
        });
    };
    return LoadingBlower;
}());
