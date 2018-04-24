/***
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.twostepsfromjava.cloud.web.mall.service;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;

/**
 * Product Service
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */

public class ObservableCommandHelloFailure extends HystrixObservableCommand<String> {
    private String name;

    public ObservableCommandHelloFailure(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup")));
        this.name = name;
    }

    @Override
    protected Observable<String> construct() {
        return Observable.just("Hello " + this.name + "!");
    }

    @Override
    protected Observable<String> resumeWithFallback() {
        return Observable.just("Hello Failure " + this.name + "!");
    }
}
