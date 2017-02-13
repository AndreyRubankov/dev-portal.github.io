/**
 * Custom select component
 */
var self;
class CustomInput {
	constructor({onFocusMethod, data = {value: '', isDirty: false, required: false},  cssClass = '', validationModel}) {
		self = this;
		this.data = data;
		this.focusMethod = onFocusMethod;
		this.placeholder = data.placeholder || data.name;
		this.id = data.name;
		this.textarea = data.style === 'requestBody';
		this.isVirgin = ko.observable(true);
		// css classes
		this.cssClass = cssClass;

		// Dirty watcher
		this.fieldWatcher(data);

		// Validation
		this.initValidation(data, validationModel);
	}

	fieldWatcher(data) {
		this.isDirty = data.isDirty = ko.pureComputed(() => {
			return !!(data.value().toString()).trim().length;
		});
	}

	initValidation(data, validationModel) {
		let obj = {required: data.required};

		// validation by type
		switch (data.type) {
			case 'integer':
				obj.nullableInt = data.value;
				break;
		}
		this.value = data.value.extend(obj);
		let model = ko.unwrap(validationModel);
		model[data.name] = this.value;
		validationModel(model);
	}

	onFocusMethod(data) {
		this.focusMethod && this.focusMethod(data)
	}

	/**
	 * Enter key handler
	 * @param model
	 * @param event
	 */
	onKeyDown(model, event) {
		this.isVirgin(false);
		let btn = $('#api-exp-get-btn');
		if (event.keyCode === 13 && btn.is(':enabled')) {
			btn.trigger('click');
		} else {
			return true;
		}
	}
}

ko.components.register('custom-input', {
	viewModel: CustomInput,
	template: `
		<div data-bind="css: {[cssClass]: true, dirty: isDirty, virgin: isVirgin}" class="api-exp-custom-input">
			<div data-bind="validationElement: value" class="custom-input__inner-wrapper">
				<!-- ko ifnot: textarea -->
				<input data-bind="textInput: value, lazyLoader: {name: placeholder, val: value}, dateTimePicker, event: {focus: onFocusMethod(data), keydown: onKeyDown.bind($component)}, attr: {id: id}"
								type="text"
								class="custom-input__field form-control">
				<!-- /ko -->
				<!-- ko if: textarea -->
				<textarea data-bind="textInput: value, lazyLoader: {name: placeholder, val: value}, dateTimePicker, event: {focus: onFocusMethod(data)}, attr: {id: id}" 
									cols="30" rows="10"
									class="custom-textarea custom-input__field form-control"></textarea>
				<!-- /ko -->
				<span data-bind="text: placeholder, css: {required: data.required}" class="custom-input__placeholder"></span>
			</div>
			<p data-bind="validationMessage: value, css: {textarea: textarea}" class="custom-input__validation-message"></p>
		</div>
`});

module.exports = CustomInput;
