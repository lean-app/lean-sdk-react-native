#import "React/RCTViewManager.h"

@interface RCT_EXTERN_MODULE(LeanSdkViewManager, RCTViewManager)

RCT_EXPORT_VIEW_PROPERTY(userToken, NSString)
RCT_EXPORT_VIEW_PROPERTY(options, NSDictionary *)
RCT_EXPORT_VIEW_PROPERTY(theme, NSDictionary *)

@end
