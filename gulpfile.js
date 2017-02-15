var gulp  = require('gulp');
var shell = require('gulp-shell');

gulp.task('server', shell.task([
	'jekyll serve --no-watch'
]));

gulp.task('serve', shell.task([
	'jekyll build -I --limit_posts 1'
]));

gulp.task('js', shell.task([
	'webpack'
]));

gulp.task('sass', shell.task([
	'sass _sass/style.scss:_site/css/main.css --sourcemap=inline --scss --style=nested'
]));

gulp.task('watch', function () {
	gulp.watch([
		'scripts/api-explorer/v2/src/**/*.js',
		'scripts/api-explorer/v2/**/*.json'
	], ['js']);

	gulp.watch([
		'_sass/**/*.scss'
	], ['sass']);

	gulp.watch([
		'_includes/**/*.html',
		'_layouts/**/*.html',
		'*/**/*.md',
		'scripts/pages/**/*.js'
	], ['serve']);
});

gulp.task('prod', shell.task([
	'npm run build',
	'rm -rf _site/css/main.css.map',
	'sass _sass/style.scss:_site/css/main.css --scss --style=compressed'
]));

gulp.task('revers', ['js', 'serve']);
gulp.task('default', ['server', 'watch']);
