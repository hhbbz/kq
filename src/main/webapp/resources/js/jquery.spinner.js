;(function ($) {
  $.fn.spinner = function (opts) {
    return this.each(function () {
      var defaults = {value:0, min:0}
      var options = $.extend(defaults, opts)
      var keyCodes = {up:38, down:40}
      var container = $('<div></div>')
      container.addClass('spinner')
      var textField = $(this).addClass('value').attr('maxlength', '2').val(options.value)
        .bind('keyup paste change', function (e) {
          var field = $(this)
          var id = $(this).attr("id")
          var money = $('a.money'+id).text()
          $("#total"+id).html((getValue(field)*money).toFixed(2));//toFixed()是保留小数点的函数很实用哦
          if (e.keyCode == keyCodes.up) changeValue(1)
          else if (e.keyCode == keyCodes.down) changeValue(-1)
          else if (getValue(field) != container.data('lastValidValue')) validateAndTrigger(field)
        })
      textField.wrap(container)

      var increaseButton = $('<button type="button" class="increase">+</button>').click(function () { changeValue(1) })
      var decreaseButton = $('<button type="button" class="decrease">-</button>').click(function () { changeValue(-1) })

      validate(textField)
      container.data('lastValidValue', options.value)
      textField.before(decreaseButton)
      textField.after(increaseButton)

      function changeValue(delta) {
        textField.val(getValue() + delta)
        validateAndTrigger(textField)
        var id = $(textField).attr("id")
        var money = $('a.money'+id).text()
        $("#total"+id).html((textField.val()*money).toFixed(2));//toFixed()是保留小数点的函数很实用哦
      }

      function validateAndTrigger(field) {
        clearTimeout(container.data('timeout'))
        var value = validate(field)
        if (!isInvalid(value)) {
          textField.trigger('update', [field, value])
        }
      }

      function validate(field) {
          var value = getValue()
          var id = $(textField).attr("id")
        if (value <= options.min){
            decreaseButton.attr('disabled', 'disabled')
            $("input.cart[id="+id+"]").attr('disabled' , 'true')
        }
        else{
            decreaseButton.removeAttr('disabled')
            $("input.cart[id="+id+"]").removeAttr('disabled')
        }
        field.toggleClass('invalid', isInvalid(value)).toggleClass('passive', value === 0)
        if (isInvalid(value)) {
          var timeout = setTimeout(function () {
            textField.val(container.data('lastValidValue'))
            validate(field)
          }, 500)
          container.data('timeout', timeout)
        } else {
          container.data('lastValidValue', value)
        }
        return value
      }

      function isInvalid(value) { return isNaN(+value) || value < options.min; }

      function getValue(field) {
        field = field || textField;
        return parseInt(field.val() || 0, 10)
      }
    })
  }
})(jQuery)