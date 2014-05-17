/**
 * Created by Damqnov on 14-5-16.
 */


if (!Object.prototype.extend) {
    Object.prototype.extend = function(properties) {
        function f() {};
        f.prototype = Object.create(this);
        for (var prop in properties) {
            f.prototype[prop] = properties[prop];
        }
        f.prototype._super = this;
        return new f();
    }
}