var secKill = {
    URL: {
        now: function (){
            return '/secKill/time/now';
        },

        exposer: function (secKillId){
            return '/secKill/' + secKillId + '/exposer';
        },

        execution: function (secKillId, md5){
            return '/secKill/' + secKillId + '/' + md5 + '/execution';
        }
    },

    validatePhone: function (phone){
        return phone && phone.length === 11 && !isNaN(phone);
    },

    handleSecKillKill: function (secKillId, node){
        node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>');
        $.post(secKill.URL.exposer(secKillId), {}, function (result){
            if (result && result['data']){
                var exposer = result['data'];
                if (exposer['exposed']){
                    // 开启秒杀
                    var md5 = exposer['md5'];
                    var killUrl = secKill.URL.execution(secKillId, md5);
                    $('#killBtn').one('click', function (){
                        $(this).addClass('disabled');
                        $.post(killUrl, {}, function (result){
                            if (result && result['success']){
                                var killResult = result['data'];
                                var state = killResult['state'];
                                var stateInfo = killResult['stateInfo'];

                                node.html('<span class="label label-success">' + stateInfo + '</span>');
                            }
                        });
                    });
                    node.show();
                } else {
                    // 未开启秒杀
                    var now = exposer['now'];
                    var start = exposer['start'];
                    var end = exposer['end'];
                    // 重新计算计时逻辑
                    secKill.countDown(secKillId, now, start, end);
                }
            } else {
                console.log('result:' + result);
            }
        })
    },

    countDown: function (secKillId, nowTime, startTime, endTime){
        var secKillBox = $('#secKill-box');

        if (nowTime > endTime){
            secKillBox.html('秒杀结束');
        } else if (nowTime < startTime) {
            secKillBox.html('秒杀尚未开始');
            var killTime = new Date(startTime + 1000);
            secKillBox.countdown(killTime, function (event){
                var format = event.strftime('秒杀倒计时：%D天 %H时 %M分 %S秒');
                secKillBox.html(format);
            }).on('finish.countdown', function (){
                secKill.handleSecKillKill(secKillId, secKillBox);
            });
        } else {
            // 秒杀开始
            secKill.handleSecKillKill(secKillId, secKillBox);
        }
    },

    detail: {
        init: function (params){
            var killPhone = $.cookie('killPhone');

            if (!secKill.validatePhone(killPhone)){
                var killPhoneModal = $('#killPhoneModal');

                killPhoneModal.modal({
                    show: true,
                    backdrop: 'static',
                    keyboard: false
                });

                $('#killPhoneBtn').click(function (){
                    var inputPhone = $('#killPhoneKey').val();
                    console.log(inputPhone);
                    if (secKill.validatePhone(inputPhone)){
                        $.cookie('killPhone', inputPhone, {expires: 7, path: '/secKill'});
                        window.location.reload();
                    } else {
                        $('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误！</label>').show(300);
                    }
                });
            }

            // 已经登录
            var startTime = params['startTime'];
            var endTime = params['endTime'];
            var secKillId = params['secKillId'];

            $.get(secKill.URL.now(), {}, function (result){
                if (result && result['success']){
                    var nowTime = result['data'];
                    secKill.countDown(secKillId, nowTime, startTime, endTime);
                } else {
                  console.log('result:' + result);
                }
            })

        }
    }
}