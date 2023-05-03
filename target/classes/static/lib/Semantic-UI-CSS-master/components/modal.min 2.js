!function(e,n,i,t){"use strict";n=void 0!==n&&n.Math==Math?n:"undefined"!=typeof self&&self.Math==Math?self:Function("return this")(),e.fn.modal=function(o){var a,r=e(this),s=e(n),c=e(i),l=e("body"),d=r.selector||"",u=(new Date).getTime(),m=[],f=arguments[0],g="string"==typeof f,h=[].slice.call(arguments,1),v=n.requestAnimationFrame||n.mozRequestAnimationFrame||n.webkitRequestAnimationFrame||n.msRequestAnimationFrame||function(e){setTimeout(e,0)};return r.each(function(){var r,b,p,y,k,w,C,S,M,H=e.isPlainObject(o)?e.extend(!0,{},e.fn.modal.settings,o):e.extend({},e.fn.modal.settings),F=H.selector,T=H.className,A=H.namespace,D=H.error,x="."+A,O="module-"+A,z=e(this),q=e(H.context),E=z.find(F.close),j=this,N=z.data(O),P=!1;M={initialize:function(){M.verbose("Initializing dimmer",q),M.create.id(),M.create.dimmer(),M.refreshModals(),M.bind.events(),H.observeChanges&&M.observeChanges(),M.instantiate()},instantiate:function(){M.verbose("Storing instance of modal"),N=M,z.data(O,N)},create:{dimmer:function(){var n={debug:H.debug,dimmerName:"modals"},i=e.extend(!0,n,H.dimmerSettings);e.fn.dimmer!==t?(M.debug("Creating dimmer"),y=q.dimmer(i),H.detachable?(M.verbose("Modal is detachable, moving content into dimmer"),y.dimmer("add content",z)):M.set.undetached(),k=y.dimmer("get dimmer")):M.error(D.dimmer)},id:function(){C=(Math.random().toString(16)+"000000000").substr(2,8),w="."+C,M.verbose("Creating unique id for element",C)}},destroy:function(){M.verbose("Destroying previous modal"),z.removeData(O).off(x),s.off(w),k.off(w),E.off(x),q.dimmer("destroy")},observeChanges:function(){"MutationObserver"in n&&((S=new MutationObserver(function(e){M.debug("DOM tree modified, refreshing"),M.refresh()})).observe(j,{childList:!0,subtree:!0}),M.debug("Setting up mutation observer",S))},refresh:function(){M.remove.scrolling(),M.cacheSizes(),M.set.screenHeight(),M.set.type(),M.set.position()},refreshModals:function(){b=z.siblings(F.modal),r=b.add(z)},attachEvents:function(n,i){var t=e(n);i=e.isFunction(M[i])?M[i]:M.toggle,t.length>0?(M.debug("Attaching modal events to element",n,i),t.off(x).on("click"+x,i)):M.error(D.notFound,n)},bind:{events:function(){M.verbose("Attaching events"),z.on("click"+x,F.close,M.event.close).on("click"+x,F.approve,M.event.approve).on("click"+x,F.deny,M.event.deny),s.on("resize"+w,M.event.resize)}},get:{id:function(){return(Math.random().toString(16)+"000000000").substr(2,8)}},event:{approve:function(){P||!1===H.onApprove.call(j,e(this))?M.verbose("Approve callback returned false cancelling hide"):(P=!0,M.hide(function(){P=!1}))},deny:function(){P||!1===H.onDeny.call(j,e(this))?M.verbose("Deny callback returned false cancelling hide"):(P=!0,M.hide(function(){P=!1}))},close:function(){M.hide()},click:function(n){var t=e(n.target).closest(F.modal).length>0,o=e.contains(i.documentElement,n.target);!t&&o&&(M.debug("Dimmer clicked, hiding all modals"),M.is.active()&&(M.remove.clickaway(),H.allowMultiple?M.hide():M.hideAll()))},debounce:function(e,n){clearTimeout(M.timer),M.timer=setTimeout(e,n)},keyboard:function(e){27==e.which&&(H.closable?(M.debug("Escape key pressed hiding modal"),M.hide()):M.debug("Escape key pressed, but closable is set to false"),e.preventDefault())},resize:function(){y.dimmer("is active")&&(M.is.animating()||M.is.active())&&v(M.refresh)}},toggle:function(){M.is.active()||M.is.animating()?M.hide():M.show()},show:function(n){n=e.isFunction(n)?n:function(){},M.refreshModals(),M.set.dimmerSettings(),M.showModal(n)},hide:function(n){n=e.isFunction(n)?n:function(){},M.refreshModals(),M.hideModal(n)},showModal:function(n){n=e.isFunction(n)?n:function(){},M.is.animating()||!M.is.active()?(M.showDimmer(),M.cacheSizes(),M.set.position(),M.set.screenHeight(),M.set.type(),M.set.clickaway(),!H.allowMultiple&&M.others.active()?M.hideOthers(M.showModal):(H.allowMultiple&&H.detachable&&z.detach().appendTo(k),H.onShow.call(j),H.transition&&e.fn.transition!==t&&z.transition("is supported")?(M.debug("Showing modal with css animations"),z.transition({debug:H.debug,animation:H.transition+" in",queue:H.queue,duration:H.duration,useFailSafe:!0,onComplete:function(){H.onVisible.apply(j),H.keyboardShortcuts&&M.add.keyboardShortcuts(),M.save.focus(),M.set.active(),H.autofocus&&M.set.autofocus(),n()}})):M.error(D.noTransition))):M.debug("Modal is already visible")},hideModal:function(n,i){n=e.isFunction(n)?n:function(){},M.debug("Hiding modal"),!1!==H.onHide.call(j,e(this))?(M.is.animating()||M.is.active())&&(H.transition&&e.fn.transition!==t&&z.transition("is supported")?(M.remove.active(),z.transition({debug:H.debug,animation:H.transition+" out",queue:H.queue,duration:H.duration,useFailSafe:!0,onStart:function(){M.others.active()||i||M.hideDimmer(),H.keyboardShortcuts&&M.remove.keyboardShortcuts()},onComplete:function(){H.onHidden.call(j),M.restore.focus(),n()}})):M.error(D.noTransition)):M.verbose("Hide callback returned false cancelling hide")},showDimmer:function(){y.dimmer("is animating")||!y.dimmer("is active")?(M.debug("Showing dimmer"),y.dimmer("show")):M.debug("Dimmer already visible")},hideDimmer:function(){y.dimmer("is animating")||y.dimmer("is active")?y.dimmer("hide",function(){M.remove.clickaway(),M.remove.screenHeight()}):M.debug("Dimmer is not visible cannot hide")},hideAll:function(n){var i=r.filter("."+T.active+", ."+T.animating);n=e.isFunction(n)?n:function(){},i.length>0&&(M.debug("Hiding all visible modals"),M.hideDimmer(),i.modal("hide modal",n))},hideOthers:function(n){var i=b.filter("."+T.active+", ."+T.animating);n=e.isFunction(n)?n:function(){},i.length>0&&(M.debug("Hiding other modals",b),i.modal("hide modal",n,!0))},others:{active:function(){return b.filter("."+T.active).length>0},animating:function(){return b.filter("."+T.animating).length>0}},add:{keyboardShortcuts:function(){M.verbose("Adding keyboard shortcuts"),c.on("keyup"+x,M.event.keyboard)}},save:{focus:function(){p=e(i.activeElement).blur()}},restore:{focus:function(){p&&p.length>0&&p.focus()}},remove:{active:function(){z.removeClass(T.active)},clickaway:function(){H.closable&&k.off("click"+w)},bodyStyle:function(){""===l.attr("style")&&(M.verbose("Removing style attribute"),l.removeAttr("style"))},screenHeight:function(){M.debug("Removing page height"),l.css("height","")},keyboardShortcuts:function(){M.verbose("Removing keyboard shortcuts"),c.off("keyup"+x)},scrolling:function(){y.removeClass(T.scrolling),z.removeClass(T.scrolling)}},cacheSizes:function(){z.addClass(T.loading);var o=z.prop("scrollHeight"),a=z.outerHeight();M.cache!==t&&0===a||(M.cache={pageHeight:e(i).outerHeight(),height:a+H.offset,scrollHeight:o+H.offset,contextHeight:"body"==H.context?e(n).height():y.height()},M.cache.topOffset=-M.cache.height/2),z.removeClass(T.loading),M.debug("Caching modal and container sizes",M.cache)},can:{fit:function(){var e=M.cache.contextHeight,n=M.cache.contextHeight/2,i=M.cache.topOffset,t=M.cache.scrollHeight,o=M.cache.height,a=H.padding;return t>o?n+i+t+a<e:o+2*a<e}},is:{active:function(){return z.hasClass(T.active)},animating:function(){return z.transition("is supported")?z.transition("is animating"):z.is(":visible")},scrolling:function(){return y.hasClass(T.scrolling)},modernBrowser:function(){return!(n.ActiveXObject||"ActiveXObject"in n)}},set:{autofocus:function(){var e=z.find("[tabindex], :input").filter(":visible"),n=e.filter("[autofocus]"),i=n.length>0?n.first():e.first();i.length>0&&i.focus()},clickaway:function(){H.closable&&k.on("click"+w,M.event.click)},dimmerSettings:function(){if(e.fn.dimmer!==t){var n={debug:H.debug,dimmerName:"modals",variation:!1,closable:"auto",duration:{show:H.duration,hide:H.duration}},i=e.extend(!0,n,H.dimmerSettings);H.inverted?(i.variation=i.variation!==t?i.variation+" inverted":"inverted",k.addClass(T.inverted)):k.removeClass(T.inverted),H.blurring?y.addClass(T.blurring):y.removeClass(T.blurring),q.dimmer("setting",i)}else M.error(D.dimmer)},screenHeight:function(){M.can.fit()?l.css("height",""):(M.debug("Modal is taller than page content, resizing page height"),l.css("height",M.cache.height+2*H.padding))},active:function(){z.addClass(T.active)},scrolling:function(){y.addClass(T.scrolling),z.addClass(T.scrolling)},type:function(){M.can.fit()?(M.verbose("Modal fits on screen"),M.others.active()||M.others.animating()||M.remove.scrolling()):(M.verbose("Modal cannot fit on screen setting to scrolling"),M.set.scrolling())},position:function(){M.verbose("Centering modal on page",M.cache),M.can.fit()?z.css({top:"",marginTop:M.cache.topOffset}):z.css({marginTop:"",top:c.scrollTop()})},undetached:function(){y.addClass(T.undetached)}},setting:function(n,i){if(M.debug("Changing setting",n,i),e.isPlainObject(n))e.extend(!0,H,n);else{if(i===t)return H[n];e.isPlainObject(H[n])?e.extend(!0,H[n],i):H[n]=i}},internal:function(n,i){if(e.isPlainObject(n))e.extend(!0,M,n);else{if(i===t)return M[n];M[n]=i}},debug:function(){!H.silent&&H.debug&&(H.performance?M.performance.log(arguments):(M.debug=Function.prototype.bind.call(console.info,console,H.name+":"),M.debug.apply(console,arguments)))},verbose:function(){!H.silent&&H.verbose&&H.debug&&(H.performance?M.performance.log(arguments):(M.verbose=Function.prototype.bind.call(console.info,console,H.name+":"),M.verbose.apply(console,arguments)))},error:function(){H.silent||(M.error=Function.prototype.bind.call(console.error,console,H.name+":"),M.error.apply(console,arguments))},performance:{log:function(e){var n,i;H.performance&&(i=(n=(new Date).getTime())-(u||n),u=n,m.push({Name:e[0],Arguments:[].slice.call(e,1)||"",Element:j,"Execution Time":i})),clearTimeout(M.performance.timer),M.performance.timer=setTimeout(M.performance.display,500)},display:function(){var n=H.name+":",i=0;u=!1,clearTimeout(M.performance.timer),e.each(m,function(e,n){i+=n["Execution Time"]}),n+=" "+i+"ms",d&&(n+=" '"+d+"'"),(console.group!==t||console.table!==t)&&m.length>0&&(console.groupCollapsed(n),console.table?console.table(m):e.each(m,function(e,n){console.log(n.Name+": "+n["Execution Time"]+"ms")}),console.groupEnd()),m=[]}},invoke:function(n,i,o){var r,s,c,l=N;return i=i||h,o=j||o,"string"==typeof n&&l!==t&&(n=n.split(/[\. ]/),r=n.length-1,e.each(n,function(i,o){var a=i!=r?o+n[i+1].charAt(0).toUpperCase()+n[i+1].slice(1):n;if(e.isPlainObject(l[a])&&i!=r)l=l[a];else{if(l[a]!==t)return s=l[a],!1;if(!e.isPlainObject(l[o])||i==r)return l[o]!==t&&(s=l[o],!1);l=l[o]}})),e.isFunction(s)?c=s.apply(o,i):s!==t&&(c=s),e.isArray(a)?a.push(c):a!==t?a=[a,c]:c!==t&&(a=c),s}},g?(N===t&&M.initialize(),M.invoke(f)):(N!==t&&N.invoke("destroy"),M.initialize())}),a!==t?a:this},e.fn.modal.settings={name:"Modal",namespace:"modal",silent:!1,debug:!1,verbose:!1,performance:!0,observeChanges:!1,allowMultiple:!1,detachable:!0,closable:!0,autofocus:!0,inverted:!1,blurring:!1,dimmerSettings:{closable:!1,useCSS:!0},keyboardShortcuts:!0,context:"body",queue:!1,duration:500,offset:0,transition:"scale",padding:50,onShow:function(){},onVisible:function(){},onHide:function(){return!0},onHidden:function(){},onApprove:function(){return!0},onDeny:function(){return!0},selector:{close:"> .close",approve:".actions .positive, .actions .approve, .actions .ok",deny:".actions .negative, .actions .deny, .actions .cancel",modal:".ui.modal"},error:{dimmer:"UI Dimmer, a required component is not included in this page",method:"The method you called is not defined.",notFound:"The element you specified could not be found"},className:{active:"active",animating:"animating",blurring:"blurring",inverted:"inverted",loading:"loading",scrolling:"scrolling",undetached:"undetached"}}}(jQuery,window,document);